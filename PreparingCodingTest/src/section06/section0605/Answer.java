package section06.section0605;

import java.util.Arrays;
import java.util.Scanner;

public class Answer {

    // 왜 굳이 정렬을 하고 중복 여부를 확인할까? 정렬 + 중복 여부 확인 = 속도가 제일 느림.
    private String solution(int n, int[] arr) {
        String answer = "U";
        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return "D";
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Answer M = new Answer();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(M.solution(n, arr));
    }
}
