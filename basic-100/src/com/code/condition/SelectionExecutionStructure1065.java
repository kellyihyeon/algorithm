package com.code.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionExecutionStructure1065 {

    // 세 정수 a, b, c가 입력되었을 때, 짝수만 출력해보자.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] rawStr = br.readLine().split(" ");
        final int a = Integer.parseInt(rawStr[0]);
        final int b = Integer.parseInt(rawStr[1]);
        final int c = Integer.parseInt(rawStr[2]);

        if (a % 2 == 0) {
            System.out.println(a);
        }

        if (b % 2 == 0) {
            System.out.println(b);
        }

        if (c % 2 == 0) {
            System.out.println(c);
        }
    }
}
