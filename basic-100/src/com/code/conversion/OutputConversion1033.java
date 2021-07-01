package com.code.conversion;

import java.util.Scanner;

public class OutputConversion1033 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = sc.nextInt();
        System.out.println(Integer.toHexString(i).toUpperCase());
    }
}
