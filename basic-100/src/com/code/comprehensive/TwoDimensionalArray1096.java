package com.code.comprehensive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array1095 {
    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            int numOfTimes = Integer.parseInt(br.readLine());   // 10
            String[] numbers = br.readLine().split(" ");
            int[] numArr = new int[numbers.length];

            for (int i = 0; i < numOfTimes; i++) {
                numArr[i] = Integer.parseInt(numbers[i]);
            }

            // 방법 1
            int min = numArr[0];
            for (int i = 1; i < numOfTimes; i++) {
                if (numArr[i] < min) {
                    min = numArr[i];
                }
            }
            System.out.println(min);

            // 방법 2: 함수 사용
            int minNum = numArr[0];
            for (int i = 1; i < numOfTimes; i++) {
                minNum = Math.min(minNum, numArr[i]);
            }
            System.out.println(minNum);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
