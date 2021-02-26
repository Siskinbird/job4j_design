package io;

import java.io.*;

/**
 * Class Analizy - analyzes server availability
 * @author Dmitry Chizhov (dimachig@gmail.com)
 * @version 1.11
 * @since 22.02.21
 */

public class Analizy {

    /**
     * Server unavailability statistics
     * @param source - Incoming data
     * @param target - Processed data
     */

    public void unavailable(String source, String target) throws IOException {
        String separate = System.lineSeparator();
        StringBuilder build = new StringBuilder();
        try (PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
                String line = reader.readLine();
                while (line != null) {
                    if (line.startsWith("400") || line.startsWith("500")) {
                        build.append(line.substring(4)).append(" - ");
                        while (line.startsWith("400") || line.startsWith("500") || line.isEmpty()) {
                            line = reader.readLine();
                        }
                        build.append(line.substring(4)).append(separate);
                        writer.write(build.toString());
                    }
                    line = reader.readLine();
                    build = new StringBuilder();
                }
            }
        }
    }
/*
Test
 */

    public static void main(String[] args) throws IOException {
        Analizy analizy = new Analizy();
        analizy.unavailable("./chapter_002/data/server.txt", "./chapter_002/data/unavailable.txt");
    }
}
