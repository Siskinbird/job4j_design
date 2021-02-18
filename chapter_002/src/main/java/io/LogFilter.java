package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            List<String> result = new ArrayList<>();
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                String[] arr = line.split(" ");
                if (arr[arr.length - 2].equals("404")) {
                    result.add(line);
                }
            }
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> log = filter("./io-data/log.txt");
        System.out.println(log);

    }
}
