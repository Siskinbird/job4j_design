package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator for even numbers
 * @author Dmitry Chizhov
 * @since 30.10.20
 * @version 1.10
 */
public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] numbers;
    private int point = 0;

    public EvenNumbersIterator(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * Checking a number for evenness
     * @param numbers - Numbers to check
     * @return - Result of checking
     */
    public boolean isEven(int[] numbers) {
        int number = numbers[point];
        return number % 2 == 0;
    }

    /**
     * Checks that the next number is even and exists
     * @return - Result of checking
     */
    @Override
    public boolean hasNext() {
        while (point < numbers.length){
            if (isEven(numbers)){
                return true;
            }
            point++;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[point++];
    }
}
