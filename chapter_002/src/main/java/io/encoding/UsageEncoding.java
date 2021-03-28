package io.encoding;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

public class UsageEncoding {
    public String readFile(String path) {             // Метод принимает путь к файлу
        StringBuilder builder = new StringBuilder(); //Строитель строк, собирает символы в строку
        try (BufferedReader br = new BufferedReader(//Открываем буффер потока чтения из файла
                new FileReader(path, Charset.forName("WINDOWS-1251")))) {             // Чтение из файла по адресу пути
            int data;                                 //Счётчик символов
            while ((data = br.read()) > 0) { // Считывает символы поочерёдно, возвращает -1 при переполнении буфера
                builder.append((char) data); // Собирает строку из символов ((символ) его интовое представление)
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString(); // Возвращает собранную строку в виде читаемой стринги
    }

    public void writeDataInFile(String path, String data) { // Запись из пути в новый файл
        try (BufferedWriter br = new BufferedWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) { // Открываем поток записи символов в файл
            // append говорит о том, что данные будут ДОЗАПИСЫВАТЬСЯ в файл, а не перезаписываться
            br.write(data + System.lineSeparator()); // ДОзаписываем в файл данные разделяется , СЕПАРАТОР добавляет символы  "\r\n" в строку) хе хе)
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        String path = "./chapter_002/data/text.txt";       //Файл из которого будем читать
        UsageEncoding usageEncoding = new UsageEncoding(); // Экземпляр нашего класса
        List<String> strings = List.of(// Список строк
                "Новая строка 1",
                "Новая строка 2",
                "Новая строка 3",
                "Новая строка 4",
                "Новая строка 5"
        );
        for (String str : strings) { // Идём по списку
            usageEncoding.writeDataInFile(path, str); //записываем список через кодировку указанную во врайтере!
        }
        String s = usageEncoding.readFile(path); // Записываем в строку результат работы метода
        System.out.println("Data from file: "); // Выводим обработанные данные
        System.out.println(s); // Выводим обработанные данные
    }
}
