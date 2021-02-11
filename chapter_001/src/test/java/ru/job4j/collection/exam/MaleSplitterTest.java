package ru.job4j.collection.exam;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MaleSplitterTest {
    @Test
    public void whenSomeUsersHaveSameEmailThenNewSize() {
        Set<String> user1 = new HashSet<>();
        Set<String> user2 = new HashSet<>();
        Set<String> user3 = new HashSet<>();
        Set<String> user4 = new HashSet<>();
        Set<String> user5 = new HashSet<>();

        user1.add("xxx@ya.ru");
        user1.add("foo@gmail.com");
        user1.add("lol@mail.ru");
        user2.add("foo@gmail.com");
        user2.add("ups@pisem.net");
        user3.add("xyz@pisem.net");
        user3.add("vasya@pupkin.com");
        user4.add("ups@pisem.net");
        user4.add("aaa@bbb.ru");
        user5.add("xyz@pisem.net");

        HashMap<String, Set<String>> inputData = new HashMap<>();
        inputData.put("Semen", user1);
        inputData.put("Nikolay", user2);
        inputData.put("Afanasiy", user3);
        inputData.put("Elvira", user4);
        inputData.put("Kapitalina", user5);
        System.out.println("Входные данные" + inputData);

        Map<String, Set<String>> outputData = MaleSplitter.merge(inputData);

        List<String> users = new ArrayList<>(outputData.keySet());
        System.out.println("Выходные данные" + outputData);
        String user = users.get(0);
        assertThat(outputData.get(user).size(), is(3));

    }
}
