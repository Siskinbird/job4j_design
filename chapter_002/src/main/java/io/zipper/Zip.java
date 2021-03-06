package io.zipper;


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
 * @version 1.33
 * @since 12.03.21
 */

public class Zip {
    private ArgZip argZip;
    private List<Path> paths = new ArrayList<>();

    public Zip(ArgZip argZip) {
        this.argZip = argZip;

        if (!argZip.valid()) {
            throw new IllegalArgumentException("Not all arguments");
        }
    }

    /**
     * Method excludeList() - Excludes getting into the list of files specified in the filter
     // * @param root - Incoming path list
     * @return - list of paths after filtering
     * @throws IOException - exception
     */

    public List<Path> excludeList() throws IOException {
        SearchFiles searcher = new SearchFiles(p -> !p.toFile().getName().endsWith(argZip.exclude()));
        Files.walkFileTree(Paths.get(argZip.directory()), searcher);
        paths.addAll(searcher.getPaths());
        return paths;
    }

    /**
     * Method packFiles() - Implements packing files into an archive
     */

    public void packFiles() throws IOException {
        try (ZipOutputStream zipPack = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(argZip.output())))) {
            for (Path source : paths) {
                zipPack.putNextEntry(
                        new ZipEntry(source.toFile().getAbsolutePath()));
                try (BufferedInputStream out = new BufferedInputStream(
                        new FileInputStream(source.toFile().getPath()))) {
                    zipPack.write(out.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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
        if (!argZip.valid()) {
            throw new IllegalArgumentException("Not all arguments");
        }
        Zip zip = new Zip(argZip);
        zip.excludeList();
        zip.packFiles();
    }
}