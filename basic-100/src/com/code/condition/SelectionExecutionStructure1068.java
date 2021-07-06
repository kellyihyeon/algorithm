package com.code.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionExecutionStructure1068 {

    // 점수(정수, 0 ~ 100)를 입력받아 평가를 출력해보자.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int i = Integer.parseInt(br.readLine());

        if (i >= 90 && i <= 100) {
            System.out.println("A");
        } else if (i >= 70 && i < 90) {
            System.out.println("B");
        } else if (i >= 40 && i < 70) {
            System.out.println("C");
        } else if (i >= 0 && i < 40) {
            System.out.println("D");
        }//
    }
}
