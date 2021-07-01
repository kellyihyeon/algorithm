package com.code.print;

import java.util.Scanner;

public class InputOutput16 {

    // 1027
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 1. 입력 받기
        String date = sc.next();

        // 2. 년.월.일 분리하기 -> 배열에 년.월.일 저장하기
        String[] dateSplit = date.split("\\.");

        System.out.printf("%s-%s-%s", dateSplit[2], dateSplit[1], dateSplit[0]);

    } //main
}