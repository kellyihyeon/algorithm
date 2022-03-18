package section07.section0701;

import java.util.Scanner;

/**
 * 재귀함수
 * 자연수 n이 입력되면 재귀함수를 이용하여 1부터 n까지 출력하라.
 */
public class Main {

    private void recursion(int n) {
        // n = 3;
        if (n != 0) {
            recursion(n - 1);   // 3 2 1
            System.out.print(n + " ");
        }
    }

    private void solution(int n) {
        recursion(n);
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        M.solution(n);
    }
}
