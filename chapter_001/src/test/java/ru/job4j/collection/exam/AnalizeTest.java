package ru.job4j.collection.exam;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AnalizeTest {
    @Test
    public void whenNotChanged() {
        Analize.User u1 = new Analize.User(1, "A");
        Analize.User u2 = new Analize.User(2, "B");
        Analize.User u3 = new Analize.User(3, "C");
        List<Analize.User> previous = List.of(u1, u2, u3);
        List<Analize.User> current = List.of(u1, u2, u3);
        Analize.Info result = Analize.diff(previous, current);
        assertThat(result.added, is(0));
        assertThat(result.changed, is(0));
        assertThat(result.deleted, is(0));
    }

    @Test
    public void whenAllDeleted() {
        Analize.User u1 = new Analize.User(1, "A");
        Analize.User u2 = new Analize.User(2, "B");
        Analize.User u3 = new Analize.User(3, "C");
        Analize.User u4 = new Analize.User(4, "D");
        Analize.User u5 = new Analize.User(5, "E");
        Analize.User u6 = new Analize.User(6, "F");
        List<Analize.User> previous = List.of(u1, u2, u3, u4, u5, u6);
        List<Analize.User> current = List.of(u1);
        Analize.Info result = Analize.diff(previous, current);
        assertThat(result.added, is(0));
        assertThat(result.changed, is(0));
        assertThat(result.deleted, is(5));
    }

    @Test
    public void whenOneChanged() {
        Analize.User u1 = new Analize.User(1, "A");
        Analize.User u2 = new Analize.User(2, "B");
        Analize.User u3 = new Analize.User(3, "C");
        List<Analize.User> previous = List.of(u1, u2, u3);
        List<Analize.User> current = List.of(u1, new Analize.User(2, "BB"), u3);
        Analize.Info result = Analize.diff(previous, current);
        assertThat(result.added, is(0));
        assertThat(result.changed, is(1));
        assertThat(result.deleted, is(0));
    }

    @Test
    public void whenOneDeleted() {
        Analize.User u1 = new Analize.User(1, "A");
        Analize.User u2 = new Analize.User(2, "B");
        Analize.User u3 = new Analize.User(3, "C");
        List<Analize.User> previous = List.of(u1, u2, u3);
        List<Analize.User> current = List.of(u1, u3);
        Analize.Info result = Analize.diff(previous, current);
        assertThat(result.added, is(0));
        assertThat(result.changed, is(0));
        assertThat(result.deleted, is(1));
    }

    @Test
    public void whenOneAdded() {
        Analize.User u1 = new Analize.User(1, "A");
        Analize.User u2 = new Analize.User(2, "B");
        Analize.User u3 = new Analize.User(3, "C");
        List<Analize.User> previous = List.of(u1, u2, u3);
        List<Analize.User> current = List.of(u1, u2, u3, new Analize.User(4, "D"));
        Analize.Info result = Analize.diff(previous, current);
        assertThat(result.added, is(1));
        assertThat(result.changed, is(0));
        assertThat(result.deleted, is(0));
    }

    @Test
    public void whenAllChanged() {
        Analize.User u1 = new Analize.User(1, "A");
        Analize.User u2 = new Analize.User(2, "B");
        Analize.User u3 = new Analize.User(3, "C");
        List<Analize.User> previous = List.of(u1, u2, u3);
        List<Analize.User> current = List.of(new Analize.User(1, "AA"), u2, new Analize.User(4, "D"));
        Analize.Info result = Analize.diff(previous, current);
        assertThat(result.added, is(1));
        assertThat(result.changed, is(1));
        assertThat(result.deleted, is(1));
    }

    @Test
    public void whenOneChanged3Deleted() {
        Analize.User u1 = new Analize.User(1, "A");
        Analize.User u2 = new Analize.User(2, "B");
        Analize.User u3 = new Analize.User(3, "C");
        Analize.User u4 = new Analize.User(4, "D");
        Analize.User u5 = new Analize.User(5, "E");
        Analize.User u6 = new Analize.User(6, "F");
        List<Analize.User> previous = List.of(u1, u2, u3, u4, u5, u6);
        List<Analize.User> current = List.of(new Analize.User(1, "AA"), new Analize.User(2, "BB"), new Analize.User(3, "CC"));
        Analize.Info result = Analize.diff(previous, current);
        assertThat(result.added, is(0));
        assertThat(result.changed, is(3));
        assertThat(result.deleted, is(3));
    }

    @Test
    public void whenMoreAdded() {
        Analize.User u1 = new Analize.User(1, "A");
        Analize.User u2 = new Analize.User(2, "B");
        Analize.User u3 = new Analize.User(3, "C");
        Analize.User u4 = new Analize.User(4, "D");
        Analize.User u5 = new Analize.User(5, "E");
        Analize.User u6 = new Analize.User(6, "F");
        List<Analize.User> previous = List.of(u1);
        List<Analize.User> current = List.of(u1, u2, u3, u4, u5, u6);
        Analize.Info result = Analize.diff(previous, current);
        assertThat(result.added, is(5));
        assertThat(result.changed, is(0));
        assertThat(result.deleted, is(0));
    }

    @Test
    public void whenMoreDeleted() {
        Analize.User u1 = new Analize.User(1, "A");
        Analize.User u2 = new Analize.User(2, "B");
        Analize.User u3 = new Analize.User(3, "C");
        Analize.User u4 = new Analize.User(4, "D");
        Analize.User u5 = new Analize.User(5, "E");
        Analize.User u6 = new Analize.User(6, "F");
        List<Analize.User> current = List.of(u1);
        List<Analize.User> previous = List.of(u1, u2, u3, u4, u5, u6);
        Analize.Info result = Analize.diff(previous, current);
        assertThat(result.added, is(0));
        assertThat(result.changed, is(0));
        assertThat(result.deleted, is(5));
    }

}