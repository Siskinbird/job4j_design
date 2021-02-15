package io;

/**
 * Class Класс для вычисления арефметических операций + - / ^
 * @author Dmitry Chizhov dimachig@gmail.com
 * @since 10.01.20
 */
public class Calculator {
    /**
     * Сложение
     * @param first Первый параметр
     * @param second Второй параметр
     */
    public double add(double first, double second) {
        return first + second;
    }

    /**
     * Сложение
     * @param first Первый параметр
     * @param second Второй параметр
     * @param third Третий параметр
     */

    public double add(double first, double second, double third) {
        return add(first, add(second, third));

    }
    /**
     * Деление
     * @param first Первый параметр
     * @param second Второй параметр
     */

    public static void div(double first, double second) {
        double result = first / second;
        System.out.println(first + "/" + second + "=" + result);
    }
    /**
     * Умножение
     * @param first Первый параметр
     * @param second Второй параметр
     */

    public static void multiply(double first, double second) {
        double result = first * second;
        System.out.println(first + "*" + second + "=" + result);
    }
    /**
     * Вычитание
     * @param first Первый параметр
     * @param second Второй параметр
     */

    public static void subtract(double first, double second) {
        double result = first - second;
        System.out.println(first + "-" + second + "=" + result);
    }

    public static void main(String[] agrs) {
        Calculator add = new Calculator();
        System.out.println(add.add(13, 44, 98));
        div(4, 2);
        multiply(2, 1);
        subtract(10, 5);
    }
}

