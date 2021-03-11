package zipper;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) throws FileNotFoundException {
        try (ZipOutputStream zipPack = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path source : sources) {
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

    public static void main(String[] args) throws FileNotFoundException {

        new Zip().packSingleFile(
                new File("./chapter_005/pom.xml"),
                new File("./chapter_005/pom.zip")
        );
        List<Path> list = new ArrayList<>();
        Path path1 = Path.of("./chapter_002/data/server.txt");
        Path path2 = Path.of("./chapter_002/data/unavailable.txt");
        list.add(path1);
        list.add(path2);

        new Zip().packFiles(list,
                new File("./chapter_002/zipped.zip"));
    }
}