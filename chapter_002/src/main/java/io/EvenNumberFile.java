package io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) throws IOException {
        try (FileInputStream in = new FileInputStream("C:\\Projects\\job4j_design\\chapter_002\\src\\main\\java\\io\\files\\even.txt")) {
            int read;
            while ((read = in.read()) != -1) {
                if (Character.getNumericValue(read) % 2 == 0) {
                    System.out.println(Character.getNumericValue(read) + " - Even");
                }
            }
        }
    }
}
