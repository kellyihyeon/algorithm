package com.code.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionExecutionStructure1069 {

    // 평가를 문자(A, B, C, D, ...)로 입력받아 내용을 다르게 출력해보자.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final char c = br.readLine().charAt(0);

        switch (c) {
            case 'A':
                System.out.println("best!!!");
                break;
            case 'B':
                System.out.println("good!!");
                break;
            case 'C':
                System.out.println("run!");
                break;
            case 'D':
                System.out.println("slowly~");
                break;
            default:
                System.out.println("what?");
        }//switch

    }
}
