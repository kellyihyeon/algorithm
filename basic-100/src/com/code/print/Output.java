package com.code.print;

public class Output {

    public static void main(String[] args) {
        // 1001 ~ 1005
        System.out.println("Hello");
        System.out.println("Hello World");
        System.out.println("Hello\nWorld");
        System.out.println("'Hello'");
        System.out.println("\"Hello World\"");

        // 1006 ~ 1008
        System.out.println("\"!@#$%^&*()\"");
        System.out.println("\"C:\\Download\\hello.cpp\"");

        System.out.println("\u250C\u252C\u2510\n\u251C\u253C\u2524\n\u2514\u2534\u2518");

        // 가독성 좋게 수정
        System.out.print("\u250C\u252C\u2510\n");
        System.out.print("\u251C\u253C\u2524\n");
        System.out.print("\u2514\u2534\u2518");
    }
}
