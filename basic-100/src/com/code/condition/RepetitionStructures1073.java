package com.code.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 입력된 정수를 줄을 바꿔 하나씩 출력하는데, 0이 입력되면 종료한다. (0은 출력하지 않는다.)
// while 문 사용
public class RepetitionStructures1073 {

    public static void main(String[] args) throws IOException {
        // 시간 초과 나온다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        String[] strings;

        // BufferedReader 만 사용하기.
        // while 문 안에 (조건) 넣는 것 -> break 로 빠져나오는 로직을 구현을 잘 못함.
        while (true) {
//            String[] strs = br.readLine().split(" ");   // 채점 프로그램에서 NullPointerException 발생.
            s = br.readLine();   // s 가 null 일 수도 있다.
            if (s != null && !s.trim().equals("")) {
                strings = s.split(" ");
                for (String str : strings) {
                    if (str.equals("0")) {
                        break;
                    } else {
                        System.out.println(str);
                    }
                }//for
            }//if
        }//while

    }
}
