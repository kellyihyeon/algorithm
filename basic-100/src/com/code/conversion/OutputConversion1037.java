package com.code.conversion;

import java.util.Scanner;

public class OutputConversion1037 {

    public static void main(String[] args) {
        // 10진수 1개 입력 -> 아스키코드표 문자로 출력

        Scanner sc = new Scanner(System.in);

        int i = sc.nextInt();  // 65 -> char
        System.out.println((char)i);



    }
}
