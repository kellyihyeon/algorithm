package com.code.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정수 1개가 입력이 된다. 1씩 줄여나가면서 한 줄에 하나씩 1이 될 때까지 출력한다.
public class RepetitionStructures1074 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n != 0) {
            System.out.println(n);
            n -= 1;
        }

    }
}
