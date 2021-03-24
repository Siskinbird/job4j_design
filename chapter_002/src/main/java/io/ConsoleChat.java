package io;

import java.io.*;
import java.util.*;

/**
 * ConsoleChat - Communicates with the user through three teams. Writes the dialogue to a file.
 * @author Dmitry Chizhov (dimachig@gmail.com)
 * @version 1.00
 * @since 24.03.21
 */

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private List<String> answers = new ArrayList<>();
    private static final String OUT = "Закончить";
    private static final String STOP = "Стоп";
    private static final String CONTINUE = "Продолжить";

    /**
     * ConsoleChat
     * @param path - The address of the file with the bot's responses
     * @param botAnswers - File with user and bot dialogs
     */

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    /*
    The method implements the work of the bot logic, command processing
     */

    public void run() throws IOException {
        boolean rsl = true;
        String ln = System.lineSeparator();
        System.out.println("***Команды*** "
                + ln + "1.Продолжить - следующая цитата"
                + ln + "2.Стоп - остановить работу бота"
                + ln + "3.Завершить - завершить работу программы" + ln);
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        getListOfAnswers();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(botAnswers))) {
            while (!OUT.equals(command)) {
                if (STOP.equals(command)) {
                    rsl = false;
                }
                if (CONTINUE.equals(command)) {
                    rsl = true;
                }
                writer.write(command + ln);
                if (rsl) {
                    String answer = getBotAnswers();
                    System.out.println(answer);
                    writer.write(answer + ln);
                }
                command = in.nextLine();
            }
            writer.write(command);
        }
    }

    /*
    The method reads the lines with the bot's responses from the file
     */

    public void getListOfAnswers() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                answers.add(line);
            }
        }
    }

   /*
   The method returns a random bot response from a list of quotes
    */

    public String getBotAnswers() {
        String phrase;
        int index = new Random().nextInt(answers.size());
        return answers.get(index);
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat("C:\\Projects\\job4j_design\\chapter_002\\data\\botSays.txt", "C:\\Projects\\job4j_design\\chapter_002\\data\\userVSbot.txt");
        cc.run();
    }
}
