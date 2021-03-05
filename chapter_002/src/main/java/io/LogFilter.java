package io;

import java.io.*;
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

    public static void save(List<String> log, String file) throws IOException {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
        ))) {
           for (String s : log) {
               out.println(s);

           }
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> log = filter("./ru.job4j_design.io-data/log.txt");
        System.out.println(log);
        save(log, "./ru.job4j_design.io-data/log.txt");
        System.out.println(log);

    }
}
