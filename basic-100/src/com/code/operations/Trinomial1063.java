package com.code.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Trinomial1063 {

    // 큰 수 찾기기
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] rawStr = br.readLine().split(" ");

        final int a = Integer.parseInt(rawStr[0]);
        final int b = Integer.parseInt(rawStr[1]);

        System.out.printf("%d", a > b ? a : b);
    }
}
