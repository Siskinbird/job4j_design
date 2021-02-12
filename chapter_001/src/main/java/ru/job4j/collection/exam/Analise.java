package ru.job4j.collection.exam;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Analise {
    public Info diff(List<User> previous, List<User> current) {
        int changed = 0;
        int deleted = 0;
        int added = 0;
        int prevSize = previous.size();
        int currSize = current.size();
        if (prevSize < currSize) {
            deleted = prevSize - currSize;
        } else {
            added = currSize - prevSize;
        }
        Map<Integer, String> currentMap = current.stream().collect(Collectors.toMap(User::getId, User::getName));
        for (Map.Entry<Integer, String> check : currentMap.entrySet()) {
           for (User prev : previous) {
               if (!prev.getName().equals(check.getValue()) && prev.getId() == check.getKey()) {
                   changed++;
               }
           }
        }
        return new Info(changed, deleted, added);
    }

    public static class User {
        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        int id;
        String name;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {
        public Info(int changed, int deleted, int added) {
        }
    }

}

