package com.github.kellyihyeon.section03_array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * C 언어에서 strfry 함수는 입력된 문자열을 무작위로 재배열하여 새로운 문자열을 만들어낸다.
 * 두 개의 문자열이 주어질 때, 1번째 문자열을 무작위로 재배열했을 때 2번째 문자열이 나올 수 있는지 판단하라.
 * strfry 함수를 적용하여 얻어질 수 있는지 여부를 Impossible, Possible 로 나타낼 것.
 * 조건
 *   1. 테스트 케이스의 수 n: 0 < n < 1001
 *   2. 각각의 문자열의 최대 길이: 1000
 */
public class Strfry {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        while (n-- > 0) {
            int[] alphabets = new int[26];
            String s1 = scanner.next();
            String s2 = scanner.next();

            // 1번째 문자열의 문자: +1
            for (char c : s1.toCharArray()) {
                alphabets[c - 97]++;
            }

            // 2번째 문자열의 문자: -1
            for (char c : s2.toCharArray()) {
                alphabets[c - 97]--;
            }

            // 각 문자열 결과가 0이 아니면 Impossible
            boolean isPossible = true;
            for (int alphabet : alphabets) {
                if (alphabet != 0) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");

            }
        }
        scanner.close();
    }
}
