package com.code.print;

import java.util.Scanner;

public class InputOutput10 {

    // 1021
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String word = sc.next();    //shower
        char[] data = new char[word.length()];

        for (int i = 0; i < word.length(); i++) {
             data[i] = word.charAt(i);
             System.out.print(data[i]);
        }
    }
}