package ru.job4j.collection;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.util.Objects.hash;

public class NewUser {
    public static void main(String[] args) {
        Map<User, Object> users = new HashMap<>();
        final Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(1986, Calendar.OCTOBER, 31);
        User first = new User("Boris", 34, instance);
        User second = new User("Boris", 34, instance);
        users.put(first, null);
        users.put(second, null);
        for (Map.Entry<User, Object> entry : users.entrySet()) {
            User data = entry.getKey();
            System.out.println(hash(data.toString().hashCode()));
            if (first.equals(second)) {
                System.out.println("Objects equals");
            }
        }
    }
}

