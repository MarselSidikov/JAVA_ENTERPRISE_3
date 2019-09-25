package ru.itis.strings;

public class Main {
    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println(s1 == s2);
        String s3 = "Hello";
        String s5 = "Hell" + "o";
        String s4 = "Hello";
        System.out.println(s3 == s4);
        System.out.println(s1 == s4);
        System.out.println(s1.intern() == s4.intern());
        System.out.println(s5 == s4);
    }
}
