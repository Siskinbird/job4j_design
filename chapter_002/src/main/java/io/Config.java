package io;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Class Config - Accepts and processes parameters from configuration files
 * @author Dmitry Chizhov (dimachig@gmail.com)
 * @version 1.00
 * @since 19.02.21
 */

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    /**
     * Method load() - loads key-value pairs into the map
     */

    public void load() {
        try (BufferedReader in = new BufferedReader(new FileReader(this.path))) {
            in.lines()
                    .filter(i -> !(i.isEmpty() || i.startsWith("#")))
                    .forEach(i -> {
                        String[] splitter = i.split("=");
                        if (splitter.length < 2) {
                            throw new IllegalArgumentException();
                        }
                        this.values.put(splitter[0], splitter[1]);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method value() - returns value by key
     * @param key - key
     * @return value
     */

    public String value(String key) {
       return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("./chapter_002/data/pair_without_comment.properties"));
        System.out.println(new Config("./chapter_002/data/app.properties"));
    }
}

