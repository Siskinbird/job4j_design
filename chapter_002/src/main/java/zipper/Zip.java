package zipper;

import io.SearchFiles;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Class Zip - Implements packing files into an archive
 * @author Dmitry Chizhov (dimachig@gmail.com)
 * @version 1.00
 * @since 12.03.21
 */

public class Zip {
    ArgZip argZip;

    public Zip(ArgZip argZip) {
        this.argZip = argZip;

        if (!argZip.valid()) {
            throw new IllegalArgumentException("Not all arguments");
        }
    }

    /**
     * Method packFiles() - Implements packing files into an archive
     * @param sources list of paths
     * @param target file to write
     * @throws IOException - exception
     */

    public void packFiles(List<Path> sources, File target) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> !p.toFile().getName().endsWith(argZip.exclude()));
        Files.walkFileTree(Paths.get(argZip.directory()), searcher);
        sources.forEach(searcher.getPaths()::add);
        for (Path source : sources) {
            packSingleFile(source.toFile(), target);
        }
    }

    /**
     * Method packSingleFile() - Implements packing a file into an archive
     * @param source - The file to be packed
     * @param target - Zipped file
     */

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(
                    new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgZip argZip = new ArgZip(args);
        Zip zip = new Zip(argZip);

        new Zip(argZip).packSingleFile(
                new File("./chapter_005/pom.xml"),
                new File("./chapter_005/pom.zip")
        );
        List<Path> list = new ArrayList<>();
        Path path1 = Path.of("./chapter_002/data/server.txt");
        Path path2 = Path.of("./chapter_002/data/unavailable.txt");
        list.add(path1);
        list.add(path2);

        zip.packFiles(list, new File(argZip.output()));
    }
}