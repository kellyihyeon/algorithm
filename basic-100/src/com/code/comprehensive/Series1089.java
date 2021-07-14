package com.code.comprehensive;

import java.io.*;

public class Series1089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rawStr = br.readLine().split(" ");
        int a = Integer.parseInt(rawStr[0]);    // 시작 값
        int d = Integer.parseInt(rawStr[1]);    // 등차
        int n = Integer.parseInt(rawStr[2]);    // 몇 번째 수인지

        // 메모리 11168, 시간 67
        int cnt = 0;
        int num = 0;

        for (int i = a; cnt < n; i+=d) {
            cnt++;
            num = i;
        }
        System.out.println(num);

        // 방법 2: 등차수열 공식 사용
        // 메모리 11168, 시간 68
        int result = a + (n-1)*d;
        System.out.println(result);
    }
}
