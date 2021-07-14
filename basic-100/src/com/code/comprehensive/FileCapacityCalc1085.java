package com.code.comprehensive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileCapacityCalc1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] rawStr = br.readLine().split(" ");   // h b c s  44100 16 2 10
        long h = Long.parseLong(rawStr[0]);
        long b = Long.parseLong(rawStr[1]);
        long c = Long.parseLong(rawStr[2]);
        long s = Long.parseLong(rawStr[3]);

        // 방법 1
        long bit = h * b * c * s;               // 14112000 bit
        double toByte = (double)bit / 8;        // 1764000.0 byte
        double toKiloByte = toByte / 1024;      // 1722.65625 kb
        double toMegabyte = toKiloByte / 1024;  // 1.682281494140625 mb
        System.out.printf("%.1f MB", toMegabyte);

        // 방법 2
        double megaByte = (((double)(h * b * c * s) / 8) / 1024) / 1024;
        System.out.printf("%.1f MB", megaByte);

        // 방법 3
        double mb = ((h * b * c * s) / 8) / Math.pow(2, 10) / Math.pow(2, 10);
        System.out.format("%.1f MB", mb);

    }
}
