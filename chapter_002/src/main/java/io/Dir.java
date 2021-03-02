package io;

import java.io.File;
import java.util.Objects;

public class Dir {
    public static void main(String[] args) {
        File file = new File("c:\\Projects\\job4j_design");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory", file.getAbsoluteFile()));
        }
        System.out.println(String.format("size : %s", file.getTotalSpace()));
        for (File subfile : Objects.requireNonNull(file.listFiles())) {
            System.out.println(subfile.getAbsoluteFile() + " - " + getFileSizeBytes(subfile.getAbsoluteFile()));
        }
    }

    /**
     * The method gets the file size in bytes
     * @param file - file
     * @return file size in bytes
     */
    private static String getFileSizeBytes(File file) {
        return file.length() + " bytes";
    }
}
