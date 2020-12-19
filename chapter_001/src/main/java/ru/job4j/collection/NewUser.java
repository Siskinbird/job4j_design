package ru.job4j.collection;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class NewUser {
    public static void main(String[] args) {
        Map<User, Object> users = new HashMap<>();
        final Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(1986, Calendar.OCTOBER, 31);
        users.put(new User("Boris", 34, instance), null);
        users.put(new User("Boris", 34, instance), null);
        for (Map.Entry<User, Object> entry : users.entrySet()) {
            User data = entry.getKey();
            System.out.println(data.toString());
        }
    }
}
