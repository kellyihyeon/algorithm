package section10.section1002;

import java.util.Scanner;

// 돌다리 건너기 !
public class Main {

    public static int[] arr;


    private int solution(int n) {
        // 1 2 3 4 5  6  7
        // 1 2 3 5 8 13 21
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n] + arr[n - 1];
    }

    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        arr = new int[n + 1];

        System.out.println(M.solution(n));


    }
}
