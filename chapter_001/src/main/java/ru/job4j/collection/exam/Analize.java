package ru.job4j.collection.exam;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Analyze - The class implements displaying statistics on a collection
 * @author Dmitry Chizhov (dimachig@gmail.com)
 * @version 1.33
 * @since 13.02.21
 */

public class Analize {

    /**
     * Method diff presents the difference between collections
     * @param previous first collection
     * @param current second collection
     * @return Information about changing collections
     */

    public static Info diff(List<User> previous, List<User> current) {
        Map<Integer, String> previousMap = previous
                .stream().collect(Collectors.toMap(User::getId, User::getName));
        Info info = new Info();
        for (User user : current) {
            String name = previousMap.remove(user.getId());
            if (name == null) {
                info.added++;
            }
            if (name != null && !name.equals(user.name)) {
                info.changed++;
            }
        }
        info.deleted = previous.size() + info.added - current.size();

        return info;
        }

    /**
     * User data model
     */

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

    /**
     * Info data model
     */

    public static class Info {
        int added;
        int changed;
        int deleted;
    }
}

