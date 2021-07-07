package com.code.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// 첫 줄에 정수의 개수 n이 입력되고, 두 번째 줄에 n개의 정수가 공백을 두고 입력된다.
// n개의 입력된 정수를 순서대로 출력해보자.
public class RepetitionStructures1072 {

    public static void main(String[] args) throws IOException {
        // BufferedReader 사용
        // 메모리 11180, 시간 65, 코드길이 649B
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 채점 프로그램에서는 java.lang.NumberFormatException: For input string: "15             " 이라는
        // 에러 메세지가 떴는데, 입력을 첫째 줄에 다 받는 것 같아서 split 메소드 추가.
        int size = Integer.parseInt(br.readLine().split(" ")[0]);
        int[] numbers = new int[size];

        final String[] strArr = br.readLine().split(" ");

        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(strArr[i]);
        }
        for (int number : numbers) {
            System.out.println(number);
        }//for

        // Scanner 사용
        // 메모리 14372, 시간 120, 코드길이 393B
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        for (int num : nums) {
            System.out.println(num);
        }//for
    }
}
