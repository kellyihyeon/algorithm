package com.code.print;

import java.util.Scanner;

public class InputOutput08 {

    // 1019
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();     //2021.06.28
        String[] date = str.split("\\.");

        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);

        System.out.printf("%04d.%02d.%02d", year, month, day);
    }
}
