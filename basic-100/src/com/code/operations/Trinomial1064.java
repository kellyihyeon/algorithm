package com.code.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Trinomial1064 {

    // 최소값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] rawStr = br.readLine().split(" ");

        final int a = Integer.parseInt(rawStr[0]);
        final int b = Integer.parseInt(rawStr[1]);
        final int c = Integer.parseInt(rawStr[2]);

        // 메모리 11168, 시간 69
        int max = (a < b ? a : b) < c ? (a < b ? a : b) : c;
        System.out.println(max);

        // 메모리 14112, 시간 105
//        System.out.printf("%d", (a < b ? a : b) < c ? (a < b ? a : b) : c);
    }
}
