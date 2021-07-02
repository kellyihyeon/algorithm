package com.code.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Arithmetic1045 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String[] arr = str.split(" ");

        long num1 = Long.parseLong(arr[0]);
        long num2 = Long.parseLong(arr[1]);

        System.out.println(num1 + num2);
        System.out.println(num1 - num2);
        System.out.println(num1 * num2);
        System.out.println(num1 / num2);
        System.out.println(num1 % num2);
        System.out.printf("%.2f", (float)num1/num2);

    }
}
