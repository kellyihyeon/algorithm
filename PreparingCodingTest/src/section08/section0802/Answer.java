package section08.section0802;

import java.util.Scanner;

public class Answer {

    static int c;
    static int n;
    static int answer = Integer.MIN_VALUE;


    private void DFS(int level, int sum, int[] arr) {
        if (sum > c) {  // c 무게를 넘게해서 트럭에 태울 순 없다.
            return;
        }

        // ** 이렇게 간단하게 코드 한줄로 구현 할 수 있다.
        if (level == n) {   // sum 이 c 보다 작거나 같을 때 (= 수많은 경우)
            answer = Math.max(answer, sum);
        } else {
            DFS(level + 1, sum + arr[level], arr);
            DFS(level + 1, sum, arr);
        }

    }

    public static void main(String[] args) {
        final Answer A = new Answer();
        final Scanner scanner = new Scanner(System.in);

        c = scanner.nextInt();
        n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        A.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
