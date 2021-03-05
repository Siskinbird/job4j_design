package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ResultFile {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String result = Double.toString(calculator.add(1, 11));
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("./ru.job4j_design.io-data/result.txt")
                ))) {
            out.write(result);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
