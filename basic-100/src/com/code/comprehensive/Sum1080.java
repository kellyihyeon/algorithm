package com.code.comprehensive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sum1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int num = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum = sum + i;
            if (sum >= num) {
                System.out.println(i);
                break;
            }
        }//for
    }
}
