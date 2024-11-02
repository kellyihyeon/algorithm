package com.github.kellyihyeon.section10recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Multiplication {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        long a = Long.parseLong(line[0]);
        long b = Long.parseLong(line[1]);
        long c = Long.parseLong(line[2]);

        System.out.println(pow(a, b, c));
    }

    private static long pow(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }

        long val = pow(a, b/2, c);
        val = val * val % c;


        if (b % 2 == 0) {
            return val;
        }

        return val * a % c;
    }
}
