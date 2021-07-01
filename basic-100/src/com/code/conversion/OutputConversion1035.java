package com.code.conversion;

import java.util.Scanner;

public class OutputConversion1035 {

    public static void main(String[] args) {

        // 1. 16진수로 입력된 정수 1개
        // 2. 8진수로 바꾸어 출력. 10진수 -> 8진수
        // 16진수 -> 10진수 -> 8진수

        Scanner sc = new Scanner(System.in);
        // 방법 1. valueOf 사용
        Integer i = Integer.valueOf(sc.next(), 16);
        System.out.println(Integer.toOctalString(i));
        // 코드 길이:259 byte(s) / 수행 시간:110 ms / 메모리 :14248 kb

        // 방법 2. parseInt 사용
        int a = Integer.parseInt(sc.next(), 16);
        System.out.println(Integer.toOctalString(a));
        // 코드 길이:256 byte(s) / 수행 시간:108 ms / 메모리 :14244 kb


    }
}
