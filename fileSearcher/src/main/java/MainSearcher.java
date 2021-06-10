import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Class MainSearcher -
 * @author Dmitry Chizhov (dimachig@gmail.com)
 * @version 1.0 - SNAPSHOT
 * @since 09.06.21
 */

public class MainSearcher {
    private  ArgsSearcher argsSearcher;
    Searcher searcher;

    public MainSearcher(ArgsSearcher argsSearcher) {
        this.argsSearcher = argsSearcher;

        if (!argsSearcher.isValid()) {
            throw new IllegalArgumentException("Not all arguments");
        }
    }

    private String prePattern(String mask) {
        return mask.replace(".", "\\.").replaceAll("\\*", ".*");
    }

    public List<Path> foundList() throws IOException {
        List<Path> foundFiles;

        if (argsSearcher.type().equals("name")) {
            searcher = searchByName();

        } else if (argsSearcher.type().equals("mask")) {
            searcher = searchByRegEx(prePattern(argsSearcher.name()));

        } else {
            searcher = searchByRegEx(argsSearcher.name());
        }
        Files.walkFileTree(Paths.get(argsSearcher.directory()), searcher);
        foundFiles = searcher.getPathList();
        return foundFiles;
    }

    private Searcher searchByRegEx(String regEx) {
        Pattern pattern = Pattern.compile(regEx);
        return new Searcher(path -> pattern.matcher(path.getFileName().toString()).matches());
    }

    private Searcher searchByName() {
        return new Searcher(path -> path.getFileName().toString().equals(argsSearcher.name()));
    }

    public void writeToFile() throws IOException {
        List<Path> res = foundList();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(argsSearcher.writeToFile()))) {
            for (Path path : res) {
                writer.write(path.toAbsolutePath().toString());
                writer.newLine();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsSearcher argsSearcher = new ArgsSearcher(args);
        MainSearcher mainSearcher = new MainSearcher(argsSearcher);
        mainSearcher.writeToFile();

    }
}
