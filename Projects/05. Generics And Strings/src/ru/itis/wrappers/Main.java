package ru.itis.wrappers;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer i1 = new Integer(5);
        // autoboxing
        Integer i = 5;
        Integer i3 = 5;
        // autounboxing
        int x = i;
        int y = i1.intValue();

        Integer a = 123;
        Integer b = 123;

        Integer a1 = 129;
        Integer b1 = 129;
        System.out.println(a == b); // true
        System.out.println(a1 == b1); // false
    }
}
