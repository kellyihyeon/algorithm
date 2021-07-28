package com.code.comprehensive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array1093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfTimes = Integer.parseInt(br.readLine());   // 10
        String[] callArr = br.readLine().split(" ");    // 1 3 2 2 5 6 7 4 5 9
        int[] existArr = new int[23];

        for (int i = 1; i < numOfTimes + 1; i++) {
            int number = Integer.parseInt(callArr[i-1]);  // number = 1, 3, 2,
            existArr[number-1] += 1;
        }//for

        for (int i : existArr) {
            System.out.print(i + " ");
        }
    }
}
