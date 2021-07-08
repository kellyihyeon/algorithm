package com.code.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 정수(0 ~ 100) 1개를 입력받아 0부터 그 수까지 순서대로 출력해보자.
// for 사용
public class RepetitionStructures1077 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num + 1; i++) {
            System.out.println(i);
        }


    }
}
