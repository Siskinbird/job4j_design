package ru.job4j.tree;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TreeTest {

    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when4Parent13Child() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        tree.add(5, 8);
        tree.add(5, 9);
        tree.add(9, 10);
        tree.add(9, 11);
        tree.add(9, 12);
        tree.add(9, 13);
        assertThat(
                tree.findBy(9).isPresent(),
                is(true)
        );
    }

    @Test
    public void parentWithManyChildren() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(1, 5);
        tree.add(1, 6);
        tree.add(1, 8);
        tree.add(1, 9);
        tree.add(1, 10);
        tree.add(1, 11);
        tree.add(1, 12);
        tree.add(1, 13);
        assertThat(
                tree.findBy(12).isPresent(),
                is(true)
        );
    }

    @Test
    public void stringEdition() {
        Tree<String> tree = new Tree<>("Valera");
        tree.add("Valera", "Galina");
        tree.add("Valera", "Blanka");
        tree.add("Valera", "Bul-bul");
        tree.add("Valera", "Semen");
        tree.add("Valera", "Magdalena");
        tree.add("Valera", "Nikolay");
        tree.add("Valera", "Alexander");
        tree.add("Valera", "Zulfia");
        tree.add("Valera", "Roman");
        tree.add("Valera", "Innakentiy");
        tree.add("Valera", "Valdemar");
        assertThat(
                tree.findBy("Blanka").isPresent(),
                is(true)
        );
        assertThat(
                tree.findBy("Roman").isPresent(),
                is(true)
        );
        assertThat(
                tree.findBy("Galina").isPresent(),
                is(true)
        );
        assertThat(
                tree.findBy("Bul-bul").isPresent(),
                is(true)
        );
        assertThat(
                tree.findBy("Kipyato4ek").isPresent(),
                is(false)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

}