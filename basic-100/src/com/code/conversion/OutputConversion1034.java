package com.code.conversion;

import java.util.Scanner;

public class OutputConversion1034 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 반대 상황. 2진수, 8진수 16진수 -> 10진수로

        // 방법1 (Integer.valueOf = 객체 반환)
//        Integer a = Integer.valueOf(sc.next(), 8);
//        System.out.println(a);

        // 방법2 (Integer.parseInt = 정수 반환)
        int i = Integer.parseInt(sc.next(), 8);
        System.out.println(i);

    }
}
