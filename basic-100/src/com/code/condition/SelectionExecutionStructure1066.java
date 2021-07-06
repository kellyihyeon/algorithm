package com.code.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionExecutionStructure1066 {

    // 세 정수 a, b, c가 입력되었을 때, 짝(even)/홀(odd)을 출력해보자.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] rawStr = br.readLine().split(" ");

        for (String str : rawStr) {
            final int i = Integer.parseInt(str);
            if (i % 2 == 0) {
                System.out.println("even");
            } else {
                System.out.println("odd");
            }
        }//for
    }
}
