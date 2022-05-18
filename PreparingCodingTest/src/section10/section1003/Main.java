package section10.section1003;

import java.util.Scanner;

// 최대 부분 증가수열
public class Main {


    private int solution(int[] arr) {
        int[] dy = new int[arr.length];
        dy[0] = 1;

        int answer = 0;
        for (int i = 1; i < dy.length; i++) {
            int tmp = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j] && tmp < dy[j]) {
                    tmp = dy[j];
                }
            }
            dy[i] = tmp + 1;
            answer = Math.max(answer, dy[i]);
        }

        return answer;

    }

    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(M.solution(arr));

    }
}
