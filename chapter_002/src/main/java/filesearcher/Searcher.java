package filesearcher;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Searcher extends SimpleFileVisitor<Path> {
    Predicate<Path> predicate;
    List<Path> pathList = new ArrayList<>();

    public Searcher(Predicate<Path> predicate) {
        this.predicate = predicate;
    }

    public List<Path> getPathList() {
        return pathList;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {
        if (predicate.test(file)) {
            pathList.add(file);
        }
        return FileVisitResult.CONTINUE;
    }
}
