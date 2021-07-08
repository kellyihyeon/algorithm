package com.code.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 영문자(a ~ z) 1개가 입력되었을 때 그 문자까지의 알파벳을 순서대로 출력해보자.
// do ~ while 사용
public class RepetitionStructures1076 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int read = br.read();   // char 읽어서 -> int 로 out
        System.out.println("int 를 char 로 형변환 해서 출력: " + (char)read);
        System.out.println("리더기로 읽어온 int 그대로 출력: " + read);

        // read = char 에 해당하는 아스키 코드 num 값
        int alphabet = (int)'a';    // 97
        do {
            System.out.print((char)alphabet + " ");
            alphabet += 1;

        } while (alphabet <= read);

    }
}
