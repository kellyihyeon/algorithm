package com.code.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 정수 1개가 입력이 된다. 1씩 줄여나가면서 한 줄에 하나씩 0이 될 때까지 출력한다.
public class RepetitionStructures1075 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n != 0) {
            n -= 1;
            System.out.println(n);
        }
        
    }
}
