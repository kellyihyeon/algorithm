package section03.section0303;

import java.util.Scanner;

public class Answer {

    private int solution(int n, int k, int[] arr) {
        int answer = 0;
        int sum = 0;

        // 처음 k 번 매출액을 더함
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        answer = sum;

        // sliding window...! wow..........
        for (int i = k; i < n; i++) {
            sum += (arr[i] - arr[i - k]);
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) {
        Answer M = new Answer();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(M.solution(n,k,arr));
    }
}
