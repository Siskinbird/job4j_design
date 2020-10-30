package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class MatrixIt - Iterator for two-dimensional array
 * @author Dmitry Chizhov dimachig@gmail.com
 * @version 1.00
 * @since 30.10.20
 */
public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (row < data.length && column >= data[row].length) {
            column = 0;
            row++;
        }
        return (row < data.length && column < data[row].length);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int element = data[row][column];
        column++;
        return element;
    }
}