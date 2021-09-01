package section01.section0111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String11 {
    public static String solution(String str) {
        // str = KSTTTSEE
        String answer = "";
        char[] chars = str.toCharArray();
        int count = 1;

        // str = 'K 'S 'T 'T 'T 'S 'E 'E | 8글자 | 인덱스: '0,'1,'2,'3,'4,'5,'6,'7
        // answer = K S T 3 S E
        for (int i = 0; i < str.length(); i++) {
            if (i + 1 == str.length()) {    // 마지막 글자라면
                if (count > 1) {
                    answer += count;     // answer 에 2 추가.
                } else {    // count 가 1이라면 새로운 남은 글자니까
                    answer += chars[i];
                }
            } else {    // 마지막 글자 아닌 경우 반복돼야 할 로직
                if (chars[i] != chars[i + 1]) {
                    if (count > 1) {    // 이미 연속되는 문자가 있고 그 갯수를 세고 있는 중이다.
                        answer += count;
                        count = 1;  // count 리셋 = 1
                    } else {    // 처음 나온 숫자이거나, 연속되는 문자가 아니다.
                        answer += chars[i];
                    }
                } else {    // 앞글자와 뒷글자가 같으면
                    if (count < 2) {
                        answer += chars[i];     // 등록한다.-> 조건 줘야 함
                    }
                    // 이미 등록 돼있으면?
                    count++;    // 2 3 | 2
                }

            }
        }

        return answer;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String str = br.readLine();

        System.out.println(solution(str));
    }
}
