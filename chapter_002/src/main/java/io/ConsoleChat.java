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
    private final List<String> answers = new ArrayList<>();
    private final List<String> log = new ArrayList<>();
    private static final String OUT = "Закончить";
    private static final String STOP = "Стоп";
    private static final String CONTINUE = "Продолжить";

    /**
     * ConsoleChat
     * @param path - The address of the file with the bots responses
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
                + ln + "3.Закончить - завершить работу программы" + ln);
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        getListOfAnswers();
            while (!OUT.equals(command)) {
                if (STOP.equals(command)) {
                    rsl = false;
                }
                if (CONTINUE.equals(command)) {
                    rsl = true;
                    log.add(command);
                }
                if (rsl) {
                    String answer = getBotAnswers();
                    System.out.println(answer);
                    log.add(answer);
                }

                command = in.nextLine();
                log.add(command);

            }
        LogFilter.save(log, botAnswers);
        }

    /*
    The method reads the lines with the bots responses from the file
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
        int index = new Random().nextInt(answers.size());
        return answers.get(index);
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat("./chapter_002/data/botSays.txt", "./chapter_002/data/log_dialog.txt");
        cc.run();
    }
}
