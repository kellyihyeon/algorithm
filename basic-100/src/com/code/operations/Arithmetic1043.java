package com.code.operations;

import java.util.Scanner;

public class Arithmetic1043 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String[] arr = s.split(" ");
        long num1 = Long.parseLong(arr[0]);
        long num2 = Long.parseLong(arr[1]);
        System.out.println(num1%num2);

    }
}
