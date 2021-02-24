package io;

import java.io.*;

/**
 * Class Analizy - analyzes server availability
 * @author Dmitry Chizhov (dimachig@gmail.com)
 * @version 1.00
 * @since 22.02.21
 */

public class Analizy {

    /**
     * Server unavailability statistics
     * @param source - Incoming data
     * @param target - Processed data
     */

    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
            PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
                String serverDown = null;
                while (reader.ready()) {
                    String status = reader.readLine();
                    if (serverDown == null && (status.startsWith("400") || status.startsWith("500"))) {
                        writer.println(status.split(" ")[1] + " server down");
                        serverDown = status;
                    } else if (serverDown != null && (!status.startsWith("400") || !status.startsWith("500"))) {
                        writer.println(status.split(" ")[1]);
                        serverDown = null;
                    }
                }
            } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * TEST
     */

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("./chapter_002/data/server.txt", "./chapter_002/data/unavailable.txt");
        }
    }