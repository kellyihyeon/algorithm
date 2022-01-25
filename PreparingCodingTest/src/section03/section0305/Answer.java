package section03.section0305;

import java.util.Scanner;

public class Answer {

    private int solution(int n) {
        int answer = 0;
        int sum = 0;
        int lt = 0;
        // 처음부터 범위를 지정하고 시작
        int m = n / 2 + 1;
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = i+1;
        }

        // i = rt 라고 가정
        for (int i = 0; i < m; i++) {
            sum += arr[i];
            if (sum == n) {
                answer++;
            }
            while (sum >= n) {
                sum -= arr[lt++];
                if (sum == n) {
                    answer++;
                }
            }
        }



        return answer;
    }

    public static void main(String[] args) {
        Answer M = new Answer();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(M.solution(n));
    }
}
