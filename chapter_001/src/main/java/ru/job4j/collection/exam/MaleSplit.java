package ru.job4j.collection.exam;

import java.util.*;

public class MaleSplit {
    Map<String, List<String>> merge(Map<String, List<String>> input) {
        Map<String, List<String>> output = new HashMap<>();
        for (Map.Entry<String, List<String>> reMap : input.entrySet()) {
            List<String> value = new ArrayList<>(reMap.getValue());
            String key = reMap.getKey();
            if (input.containsKey(key)) {
                for (Map.Entry<String, List<String>> reMap2 : input.entrySet()) {
                    List<String> value2 = reMap2.getValue();
                    String key2 = reMap2.getKey();
                    if (!key.equals(key2) && value.removeAll(value2)) {
                        value.addAll(value2);
                    }
                }
                output.put(key, value);
            }
        }
        return output;
    }

    public static class User {

        public String name;
        public Set<String> emails;

        public User(String name, Set<String> emails) {
            this.name = name;
            this.emails = emails;
        }

        public String getName() {
            return name;
        }

        public Set<String> getEmails() {
            return emails;
        }
    }
}


