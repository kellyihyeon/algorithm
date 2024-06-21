package com.github.kellyihyeon.section03_array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * n개의 서로 다른 양의 정수로 이루어진 수열 arr 이 있고, 자연수 x가 주어진다.
 * 수열의 두 수의 합이 x를 만족하는 쌍의 수를 구하라.
 */
public class TwoNumberSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(scanner.nextLine());

        boolean[] mark = new boolean[1000001];
        int count = 0;

        for (int i = 0; i < n; i++) {
            mark[arr[i]] = true;
        }

        int numberLimit = 1000000;
        for (int i = 0; i < n; i++) {
            int targetNumber = x - arr[i];

            if (targetNumber > 0 && targetNumber <= numberLimit && mark[targetNumber]) {
                count++;
            }
        }

        System.out.println(count/2);
    }
}
