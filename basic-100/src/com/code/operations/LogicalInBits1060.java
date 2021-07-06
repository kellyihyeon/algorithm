package com.code.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LogicalInBits1060 {

    // 비트단위(bitwise)연산자 &를 사용하면 된다.(and, ampersand, 앰퍼센드라고 읽는다.)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] rawStr = br.readLine().split(" ");
        int a = Integer.parseInt(rawStr[0]);
        int b = Integer.parseInt(rawStr[1]);
        int sumInBits = a & b;  // 둘 다 1이어야 1로 만들어준다.

        System.out.printf("%d",sumInBits);
    }
}
