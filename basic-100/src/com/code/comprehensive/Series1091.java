package com.code.comprehensive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Series1091 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] rawStr = br.readLine().split(" ");
        int a = Integer.parseInt(rawStr[0]);
        int m = Integer.parseInt(rawStr[1]);
        int d = Integer.parseInt(rawStr[2]);
        int n = Integer.parseInt(rawStr[3]);

        int cnt = 0;
        long result = 0;
        // 시작 값(a), 곱할 값(m), 더할 값(d), 몇 번째인지를 나타내는 정수(n)
        for (long i = a; cnt < n; i = (i * m) + d) {
            cnt ++;
            result = i;
        }
        System.out.println(result);
    }
}
