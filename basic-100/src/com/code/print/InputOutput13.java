package com.code.print;

import java.util.Scanner;

public class InputOutput13 {

    // 1024
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 다른 사람 코드
        String word = sc.next();
        for (int i = 0; i < word.length(); i++) {
            System.out.println("'" + word.charAt(i) + "'");
        }

        // 내 코드 (굳이 왜 char[]에 저장한 거지?)
//        int wordLength = word.length();
//        char[] wordChar = new char[wordLength];
//        for (int i = 0; i < wordLength; i++) {
//            wordChar[i] = word.charAt(i);
//            System.out.println("'" + wordChar[i] +"'");
//        }

    }
}