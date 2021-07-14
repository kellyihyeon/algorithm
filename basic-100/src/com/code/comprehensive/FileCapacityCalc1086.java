package com.code.comprehensive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileCapacityCalc1086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] rawStr = br.readLine().split(" ");
        long w = Long.parseLong(rawStr[0]);
        long h = Long.parseLong(rawStr[1]);
        long b = Long.parseLong(rawStr[2]);

        double mb = (((w * h * b) / 8d) / Math.pow(2, 10)) / Math.pow(2, 10);
        System.out.printf("%.2f MB", mb);
    }
}
