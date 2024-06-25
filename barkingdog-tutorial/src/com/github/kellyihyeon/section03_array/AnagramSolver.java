package com.github.kellyihyeon.section03_array;

import java.util.Scanner;

/**
 * 두 개의 영어 단어가 주어졌을 때, 두 단어가 서로 애너그램 관계에 있도록 만드려면 제거해야 하는 문자의 수를 구하라.
 * 1 <= 영어 단어의 길이 <= 1000
 */
public class AnagramSolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        // 첫 번째, 두 번째 영어 단어의 문자 배열을 각각 만든다.
        int[] a = new int[26];
        int[] b = new int[26];
        for (char c : s1.toCharArray()) {
            a[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            b[c - 'a']++;
        }

        // 루프를 26번 돌면서 각 문자열의 개수를 비교한다.
        int answer = 0;
        for (int i = 0; i < 26; i++) {
            // 절대값(a-b) 한 다음에 결과를 누적한다.
            answer += Math.abs(a[i] - b[i]);
        }

        System.out.println(answer);
    }
}
