package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Class Search - implements file search by predicate
 * @author Dmitry Chizhov (dimachig@gmail.com)
 * @version 1.23
 * @since 04.03.21
 */
public class Search {

    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        Files.walkFileTree(start, new PrintFiles());
        search(start, "js").forEach(System.out::println);
    }

    /**
     * Method search() - implements file search by predicate
     * @param root - the address of the folder in which the search will be carried out
     * @param ext - search criteria
     * @return - found files
     * @throws IOException
     */
   public static List<Path> search(Path root, String ext) throws IOException {
       SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(ext));
       Files.walkFileTree(root, searcher);
       return searcher.getPaths();
   }
}