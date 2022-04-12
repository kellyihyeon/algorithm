package section08.section0804;

import java.util.Scanner;

/**
 * 중복 순열 구하기
 * n개의 구슬이 있다. 중복 허락하여 m 번 뽑았을 때 일렬로 나열하라. (오름차순으로)
 */
public class Main {
    static int n;
    static int m;
    static int[] arr;


    // 중복 순열 = 여러 가닥으로 뻗는다. m번
    private void DFS(int level) {
        // n = 3(구슬 갯수), m = 2(뽑는 횟수)
        if (level == m) {
            // *** i 를 어떻게 저장해놓고 출력할 것인가? -> level 이 m일 때 출력.
            for (int j = 0; j < m; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i < n + 1; i++) {   // 구슬 1,2,3
                arr[level] = i;
                DFS(level + 1);
            }
        }

    }


    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        arr = new int[m];
        M.DFS(0);
    }
}
