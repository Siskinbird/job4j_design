package ru.job4j.collection;

public class BinaryCheckHash {

    public static String binary(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            sb.append(num % 2 == 0 ? 0 : 1);
            sb.append((i + 1) % 8 == 0 ? " " : "");
            num /= 2;
        }
        return sb.reverse().toString();
    }

    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void main(String[] args) {
        System.out.println(binary(hash(123)));
        System.out.println(binary(hash(123 >>> 4)));

        System.out.println(binary(hash(255)));
        System.out.println(binary(hash(255 >>> 4)));

        System.out.println(binary(hash(420)));
        System.out.println(binary(hash(420 >>> 4)));

        System.out.println(binary(hash(Integer.MAX_VALUE)));
        System.out.println(binary(hash(Integer.MAX_VALUE >>> 16)));

        System.out.println(binary(hash(123456789)));
        System.out.println(binary(hash(123456789 >>> 16)));
        System.out.println(binary(hash(123456789 ^ (123456789 >>> 16))));
    }
}
