package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Analizy - analyzes server availability
 * @author Dmitry Chizhov (dimachig@gmail.com)
 * @version 1.23
 * @since 22.02.21
 */

public class Analizy {

    private static List<String> resultList = new ArrayList<>();

    /**
     * Method "toFile()" - implements writing the list to a file
     * @param target - path to the file to write
     */

    private static void toFile(String target) {
        try (PrintWriter writer = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)
                ))) {
            resultList.forEach(data -> writer.write(data + System.lineSeparator()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Server unavailability statistics
     *
     * @param source data provider file address
     * @param target file address for recording statistics
     */

    public static void unavailable(String source, String target) throws IOException {
        String separate = System.lineSeparator();
        StringBuilder build = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
                String line = reader.readLine();
                while (line != null) {
                    if (line.startsWith("400") || line.startsWith("500")) {
                       build.append(line.substring(4)).append(" - ");
                        resultList.add(line.split(" ")[1] + " server down");
                        while (line.startsWith("400") || line.startsWith("500") || line.isEmpty()) {
                            line = reader.readLine();
                        }
                        build.append(line.substring(4)).append(separate);
                        resultList.add(line.split(" ")[1] + " server up");
                    }
                    line = reader.readLine();
                    build = new StringBuilder();
                }
            }
        toFile(target);
        }
    }
