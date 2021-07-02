package com.code.operations;

import java.util.Scanner;

public class Arithmetic1038 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String[] strArr = s.split(" ");
        long num1 = Long.parseLong(strArr[0]);
        long num2 = Long.parseLong(strArr[1]);
        System.out.println(num1 + num2);

        // 문제의 의도
//        String str = sc.nextLine();
//        String[] strArr2 = str.split(" ");
//        int number1 = Integer.parseInt(strArr2[0]);
//        int number2 = Integer.parseInt(strArr2[1]);
//
//        long answer = (long) number1 + number2;
//        System.out.println(answer);
    }
}
