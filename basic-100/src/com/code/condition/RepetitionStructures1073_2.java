package com.code.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 입력된 정수를 줄을 바꿔 하나씩 출력하는데, 0이 입력되면 종료한다. (0은 출력하지 않는다.)
// while 문 사용
public class RepetitionStructures1073_2 {

    public static void main(String[] args) throws IOException {
        // 통과 된 코드. 메모리 11144, 시간 64, 코드길이 668B 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer 사용해보기
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals("0")) {
                break;
            } else {
                System.out.println(token);
            }
        }//while

    }
}
