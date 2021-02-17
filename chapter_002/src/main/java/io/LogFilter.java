package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {

    public static List<String> filter(String file) {
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
           List<String> lines = in.lines().filter(i -> i.contains("404")).collect(Collectors.toList());
            String[] lines1 = lines.toString().split(System.lineSeparator());
            for (String s : lines) {
                if (!s.endsWith("404")) {
                    System.out.println(s);
                }

           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<String> log = filter("./io-data/log.txt");
        System.out.println(log);

    }
}
