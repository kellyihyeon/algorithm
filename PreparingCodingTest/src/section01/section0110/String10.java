package section01.section0110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 난이도 최상
public class String10 {

    public static int[] solution2(String str) {
        // str = teachermode e
        // e a c h e r m o d e  |  e
        // for 문을 왼쪽에서, 오른쪽에서 두 번 돌리기

        final String[] rawStrArr = str.split(" ");
        char[] stringToCharArr = rawStrArr[0].toCharArray();    // t e a c h e r m o d e
        char target = rawStrArr[1].charAt(0);
        int distance = 1000;
        int[] answer = new int[stringToCharArr.length];

        // 왼 -> 오
        for (int i = 0; i < answer.length; i++) {
            if (stringToCharArr[i] == target) {
                distance = 0;
                answer[i] = distance;
            } else {
                distance++;
                answer[i] = distance;
            }
        }
        System.out.println("계산 1번째 = ");
        for (int i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 오 -> 왼
        int distance2 = 1000;
        for (int i = answer.length - 1; i > -1; i--) {   // 10
            if (stringToCharArr[i] == target) {
                distance2 = 0;
            } else {
                distance2++;    // 1
                if (distance2 < answer[i]) {    // 1 < 4
                    answer[i] = distance2;
                }
            }
        }
        System.out.println("최종 계산 = ");
        for (int i : answer) {
            System.out.print(i + " ");
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String str = br.readLine();

        int[] answer = solution2(str);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
