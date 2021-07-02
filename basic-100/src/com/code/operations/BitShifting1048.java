package com.code.operations;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitShifting1048 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        int num1 = Integer.parseInt(arr[0]);
        int num2 = Integer.parseInt(arr[1]);

        // 비트 시프트 연산자 이용
        System.out.println(num1<<num2);
        // Math 라이브러리 이용
        System.out.println(num1 * (int)Math.pow(2, num2));
    }
}
