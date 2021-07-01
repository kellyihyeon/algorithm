package com.code.conversion;

import java.util.Scanner;

public class OutputConversion1036 {

    public static void main(String[] args) {
        // 영문자 1개 입력 -> 아스키코드표 10진수로 출력

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char c = str.charAt(0);

        System.out.println((int)c);


    }
}
