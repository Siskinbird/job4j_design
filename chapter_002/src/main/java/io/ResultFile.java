package io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String result = Double.toString(calculator.add(11, 11));
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(result.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
