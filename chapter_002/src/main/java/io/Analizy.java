package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Analizy - analyzes server availability
 * @author Dmitry Chizhov (dimachig@gmail.com)
 * @version 1.21
 * @since 22.02.21
 */

public class Analizy {

    private static List<String> resultList = new ArrayList<>();
    private static List<String> tmpList = new ArrayList<>();

    /**
     * Method "toList" - implements writing data from a file to a list
     * @param source - file path to the data provider
     */

    private static void toList(String source) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            reader.lines().forEach(tmpList::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
     * @param source data provider file address
     * @param target file address for recording statistics
     */

    public static void unavailable(String source, String target) {
        toList(source);
        String start = null;
        String end;
        String resultStr;
        for (String line : tmpList) {
            if ((line.startsWith("400") || line.startsWith("500")) && start == null) {
                start = line.substring(4);
            }
            if ((line.startsWith("200") || line.startsWith("300")) && start != null) {
                end = line.substring(4);
                resultStr = start + " - " + end;
                start = null;
                resultList.add(resultStr);
            }
        }
        toFile(target);
    }
}
