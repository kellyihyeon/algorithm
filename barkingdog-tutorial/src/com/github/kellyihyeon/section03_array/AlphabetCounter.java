package com.github.kellyihyeon.section03_array;

import java.util.Scanner;

/**
 * 알파벳 소문자로만 이루어진 단어 S가 주어진다.
 * 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하라.
 */
public class AlphabetCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String alphabet = scanner.nextLine();

        int[] answers = new AlphabetCounter().countEachAlphabets(alphabet);
        for (int answer : answers) {
            System.out.print(answer + " ");
        }
    }

    private int[] countEachAlphabets(String alphabet) {
        int[] arrays = new int[26];
        for (char character : alphabet.toCharArray()) {
            int index = character - 97;
            arrays[index] = arrays[index] + 1;
        }

        return arrays;
    }
}
