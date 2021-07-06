package com.code.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LogicalInBits1062 {

     // 비트단위(bitwise) 연산자 ^(xor, circumflex/caret, 서컴플렉스/카릿)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] rawStr = br.readLine().split(" ");
        int a = Integer.parseInt(rawStr[0]);
        int b = Integer.parseInt(rawStr[1]);
        int sumInBits = a ^ b;  // 서로 다르면 1로 만들어준다.

        System.out.printf("%d",sumInBits);
    }
}
