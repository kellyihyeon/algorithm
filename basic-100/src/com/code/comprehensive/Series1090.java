package com.code.comprehensive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Series1090 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] rawStr = br.readLine().split(" ");
        long a = Long.parseLong(rawStr[0]);
        long r = Long.parseLong(rawStr[1]);
        long n = Long.parseLong(rawStr[2]);

        long cnt = 0;
        long result = 0;
        for (long i = a; cnt < n; i *= r) {
            cnt++;
            result = i;
        }
        System.out.println(result);
        br.close();

        // 방법 2
        long answer = (long) (a * Math.pow(r, n - 1));
    }
}
