package com.github.kellyihyeon.section03_array;

import java.util.Scanner;

/**
 * 총 n개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하라.
 * 조건
 *  1. 1 <= n <= 100
 *  2. -100 <= v <= 100
 */
public class Counter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] a = new int[201];
        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            a[number + 100] += 1;
        }

        int v = scanner.nextInt();
        int target = v + 100;

        System.out.println(a[target]);
    }
}
