package com.code.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 0이 아니면 입력된 정수를 출력하고, 0이 입력되면 출력을 중단해보자.
// while( ), for( ), do~while( ) 등의 반복문을 사용할 수 없다. <- 자바에는 goto 문이 없다.
public class RepetitionStructures1071 {

    public static void reload(int n) {
        System.out.println(n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] rawStr = br.readLine().split(" ");

        for (String str : rawStr) {
            final int n = Integer.parseInt(str);
            if (n != 0) {
                reload(n);
            } else {
                break;
            }
        }//for

    }
}
