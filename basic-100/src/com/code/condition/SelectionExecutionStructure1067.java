package com.code.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionExecutionStructure1067 {

    // 정수 1개가 입력되었을 때, 음(minus)/양(plus)과 짝(even)/홀(odd)을 출력해보자.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int i = Integer.parseInt(br.readLine());
        if (i < 0) {
            System.out.println("minus");
            if (i % 2 == 0) {
                System.out.println("even");
            } else {
                System.out.println("odd");
            }
        } else {
            System.out.println("plus");
            if (i % 2 == 0) {
                System.out.println("even");
            } else {
                System.out.println("odd");
            }
        }//
    }
}
