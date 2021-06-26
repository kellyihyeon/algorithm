package com.code.print;

import java.util.Scanner;

public class InputOutput02 {

    //1012
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        float nextFloat = scan.nextFloat();
        // 소수점 6자리까지 표시해야 하므로
        // String.format()메서드
        String nextFloat6 = String.format("%.6f", nextFloat);
        System.out.println(nextFloat6);

        // 한 줄로 해결하는 방법
        System.out.printf("%f", nextFloat);

        scan.close();
    }
}
