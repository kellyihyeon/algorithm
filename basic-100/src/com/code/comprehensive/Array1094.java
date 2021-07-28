package com.code.comprehensive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array1094 {
    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            int numOfTimes = Integer.parseInt(br.readLine());   // 10
            final String[] numbers = br.readLine().split(" ");
            for (int i = numOfTimes - 1; i > -1; i--) {
                System.out.print(numbers[i] + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
