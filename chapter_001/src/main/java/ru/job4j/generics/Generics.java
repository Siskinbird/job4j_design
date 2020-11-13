package ru.job4j.generics;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Class for picking generics
 * @author Dmitry Chizhov
 * @since 04.11.20
 * @version 1.00
 */

public class Generics {
    public static void main(String[] args) {
        Generics gen = new Generics();

        List<Animal> first = new ArrayList<>();
        List<Predator> second = new ArrayList<>();
        List<Tiger> third = new ArrayList<>();

        first.add(new Animal("Анфису", 87));
        second.add(new Predator("Галину", 44));
        third.add(new Tiger("Ефрасинью", 33));

        gen.printObject(first);
        gen.printObject(second);
        gen.printObject(third);
        System.out.println();

        gen.printBoundedWildCard(first);
        gen.printBoundedWildCard(second);
        gen.printBoundedWildCard(third);
        System.out.println();

        gen.printLowerBoundedWildCard(first);
        gen.printLowerBoundedWildCard(second);
        gen.printLowerBoundedWildCard(Collections.singletonList(third));
    }

    /**
     * Outputs a collection without bounded wild card
     * @param list
     */
    public void printObject(List<?> list) {
        for (Iterator<?> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Это чудесное " + next);
        }
    }

    /**
     * Wild card
     * @param list
     */
    public void printBoundedWildCard(List<? extends Animal> list) {
        for (Iterator<? extends Animal> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Это чудесное " + next);
        }
    }

    /**
     * Lower bounded wild card
     * @param list
     */
    public void printLowerBoundedWildCard(List<? super Predator> list) {
        for (Iterator<? super Predator> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Это чудесное " + next);
        }
    }
}
