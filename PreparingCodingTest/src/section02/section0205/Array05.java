package section02.section0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array05 {
    public static int solution(int n) {
        int answer = 1;     // 2는 예외
        int[] numList = new int[n];
        for (int i = 1; i < n + 1; i++) {   // 20
            numList[i - 1] = i;
        }
        // 소수 찾기

        for (int i : numList) {
            System.out.print(i + " ");
        }

        return answer;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n));
    }
}
