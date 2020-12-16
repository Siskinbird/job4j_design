package ru.job4j.it;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * public class ListUtils
 * @author Dmitry Chizhov (dimachig@gmail.com)
 * @since 26.12.2020
 * @version 1.03
 */
public class ListUtils {
    /**
     * Method addBefore() - Adds the value before the specified index
     * @param list - list
     * @param index - index
     * @param value - value
     * @param <T> - Type parameter
     */

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    /**
     * Method addAfter() - Adds the value after the specified index
     * @param list - list
     * @param index - index
     * @param value - value
     * @param <T> - Type parameter
     */

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index + 1) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    /**
     * Method removeIf() removes all elements that match the predicate
     * @param list - list
     * @param filter - Predicate
     * @param <T> -Type parameter
     * @return - Modified list
     */

    public static <T> List<T> removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> it = list.listIterator();
        while (it.hasNext()){
            if (filter.test(it.next())){
                it.remove();
            }
        }
        return list;
    }

    /**
     * Method replaceIf() - Replaces all elements that match the predicate;
     * @param list - Incoming list
     * @param filter - Predicate
     * @param value - New value
     * @param <T> - Type parameter
     * @return - Modified list
     */

    public static <T> List<T> replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> it = list.listIterator();
        while (it.hasNext()) {
            if (filter.test(it.next())) {
                it.set(value);
            }
        }
        return list;
    }

    /**
     * Method removeAll() - Removes from the list those elements that are in elements.
     * @param list - Incoming list
     * @param elements - Removed values
     * @param <T> - Type parameter
     * @return - Modified list
     */

    public static <T> List<T> removeAll(List<T> list, List<T> elements) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (elements.contains(i.next())) {
                i.remove();
            }
        }
        return list;
    }
}