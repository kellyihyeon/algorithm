package com.github.kellyihyeon.section03_array;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 백준: 2577번
 * 세 개의 자연수 A, B, C가 주어질 때 A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하라.
 */
public class NumbersCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        String str = String.valueOf(a * b * c);
        int[] nums = Stream.of(str.split("")).mapToInt(Integer::parseInt).toArray();
        int[] counter = new int[10];

        for (int num : nums) {
            counter[num] += 1;
        }

        for (int i : counter) {
            System.out.println(i);
        }
    }
}
