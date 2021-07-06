package com.code.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionExecutionStructure1070 {

    // 월이 입력될 때 계절 이름이 출력되도록 해보자.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int i = Integer.parseInt(br.readLine());

        switch (i) {
            case 3:
            case 4:
            case 5:
                System.out.println("spring");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("summer");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("fall");
                break;
            default:
                System.out.println("winter");
        }//switch

    }
}
