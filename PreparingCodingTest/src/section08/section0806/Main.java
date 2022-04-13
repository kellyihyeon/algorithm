package section08.section0806;

import java.util.Scanner;

/**
 * 순열 구하기
 * n 개의 자연수 중 m개를 뽑아 일렬로 나열하는 방법을 출력하라.
 */
public class Main {
    static int n;
    static int m;
    static int[] arr;
    static int[] check;
    static int[] answer;

    // n개의 수가 주어지고 이 중 m개를 뽑아 나열해야 한다.
    // arr = [3 6 9]
    // lv0 -             0
    // lv1-   3          6        9
    // lv2-  6 9       3  9     3  6
    // lv2와 m이 같으면 돌아간다. 돌아가기 전에 수열을 출력한다. 3, 6
    // level = m 이 되면 answer 를 출력한다.
    private void DFS(int level, int num) {  // *** num 은 사용하지 않으므로 파라미터로 전달할 필요가 없다.
        if (level == m) {
            for (int n : answer) {
                System.out.print(n + " ");
            }
            System.out.println();

        } else {
            for (int i = 0; i < n; i++) {
                if (check[i] == 0) {   // *** check 와 answer 를 응용.
                    check[i] = 1;
                    answer[level] = arr[i];
                    DFS(level + 1, arr[i]);
                    check[i] = 0;
                }
            }

        }

    }

    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);

        // 자연수 n
        n = scanner.nextInt();
        // 뽑아야 할 갯수 m
        m = scanner.nextInt();
        // 자연수 배열 arr
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        check = new int[n];
        answer = new int[m];
        M.DFS(0, 0);

    }
}
