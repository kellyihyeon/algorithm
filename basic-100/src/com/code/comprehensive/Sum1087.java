package com.code.comprehensive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sum1087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());  // num = 57

        int sum = 0;
        for (int i = 1; sum < num; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
