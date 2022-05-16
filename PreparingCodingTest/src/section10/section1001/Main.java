package section10.section1001;

import java.util.Scanner;


public class Main {
    public static int[] dy;


    private int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];  // like 피보나치
        }

        return dy[n];
    }

    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        dy = new int[n + 1];

        System.out.println(M.solution(n));
    }
}
