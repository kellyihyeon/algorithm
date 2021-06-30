package com.code.print;

import java.util.Scanner;

public class InputOutput15 {

    // 1026
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String time = sc.next();
        String[] timeArr = time.split(":");
        int minute = Integer.parseInt(timeArr[1]);

        System.out.println(minute);

    } //main
}