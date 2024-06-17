package com.github.kellyihyeon.section02_basic;

import java.util.Scanner;

/**
 * 정수 n개로 이루어진 수열 a와 정수 x가 주어진다.
 * 이때 a에서 x보다 작은 수를 모두 출력하라.
 */
public class NumberLessThanX {
    // 10 5
    // 1 10 4 9 2 3 8 5 7 6
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i : arr) {
            if (i < x) {
                System.out.print(i + " ");
            }
        }
    }
}
