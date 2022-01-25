package section03.section0306;

import java.util.Scanner;

public class Answer {

    private int solution(int n, int k, int[] arr) {
        int answer = 0;
        // cnt = 0을 1로 바꾼 횟수
        int cnt = 0;
        int lt = 0;
        // 14 2
        //1 1 0 0 1 1 '0 1 1 0 1 1 0' 1
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                cnt++;
            }
            while (cnt > k) {
                if (arr[lt] == 0) {
                    cnt--;
                }
                lt++;
            }
            answer = Math.max(answer, i - lt + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Answer A = new Answer();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(A.solution(n, k, arr));
    }
}
