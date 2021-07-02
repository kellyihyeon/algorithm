package com.code.operations;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitShifting1047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long num = Long.parseLong(br.readLine());
        System.out.println(num<<1);
    }
}
