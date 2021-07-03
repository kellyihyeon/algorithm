package com.code.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Logical1054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);

        if (a == 1 && b == 1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
