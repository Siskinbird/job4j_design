package io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String result = Double.toString(calculator.add(1, 11));
        try (FileOutputStream out = new FileOutputStream("C:\\Projects\\job4j_design\\chapter_002\\src\\main\\java\\io\\files\\result.txt")) {
            out.write(result.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}