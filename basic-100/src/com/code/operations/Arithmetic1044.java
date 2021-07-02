package com.code.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Arithmetic1044 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        long num = sc.nextLong();
        System.out.println(num+1);

        // BufferedReader 사용 시
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(n+1);
    }
}
