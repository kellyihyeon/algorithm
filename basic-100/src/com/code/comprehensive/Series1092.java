package com.code.comprehensive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Series1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] rawStr = br.readLine().split(" ");
        int a = Integer.parseInt(rawStr[0]);
        int b = Integer.parseInt(rawStr[1]);
        int c = Integer.parseInt(rawStr[2]);

        int day = 1;
        // 3 7 9일
       while (day % a != 0 || day % b != 0 || day % c != 0) {
            day++;
        }
        System.out.println(day);

    }
}
