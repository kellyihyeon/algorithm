package com.code.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LogicalInBits1061 {

    // 비트단위(bitwise) 연산자 |(or, vertical bar, 버티컬바). | 은 파이프(pipe)연산자라고도 불리는 경우가 있다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] rawStr = br.readLine().split(" ");
        int a = Integer.parseInt(rawStr[0]);
        int b = Integer.parseInt(rawStr[1]);
        int sumInBits = a | b;  // 둘 중 하나라도 1이면 1로 만들어준다.

        System.out.printf("%d",sumInBits);
    }
}
