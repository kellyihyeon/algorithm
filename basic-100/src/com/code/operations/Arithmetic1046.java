package com.code.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Arithmetic1046 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        long num1 = Long.parseLong(arr[0]);
        long num2 = Long.parseLong(arr[1]);
        long num3 = Long.parseLong(arr[2]);

        long sum = num1 + num2 + num3;
        double avg = (double) sum / 3;

        System.out.println(sum);
        System.out.printf("%.1f", avg);

    }
}
