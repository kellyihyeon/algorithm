package section08.section0809;

import java.util.Scanner;

/**
 * 조합 구하기
 * ********* 같은 실수를 하게 되는 문제
 */
public class Main {

    private static int n;
    private static int m;
    private static int[] combination;

    private void DFS(int level, int startNum) {     //d(0,1)-i=1,48, d(1,2)-i=3
        if (level == m) {
            for (int x : combination) {
                System.out.print(x + " ");
            }
            System.out.println();

        } else {
            for (int i = startNum; i < n + 1; i++) {
                combination[level] = i;
                DFS(level + 1, i + 1);
                combination[level] = 0;
            }
        }
    }


    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        combination = new int[m];

        M.DFS(0, 1);


    }
}
