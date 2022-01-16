package section02.section0210;

import java.util.Scanner;

public class Main {


    private static int solution(int n, int[][] arr) {
        int length = arr.length;
        int count = 0;

        for (int i = 1; i < length; i++) {
            for (int j = 1; j < length; j++) {
                if (arr[i][j] != 0) {
                    boolean leftAndRight = arr[i][j - 1] < arr[i][j] && arr[i][j] > arr[i][j + 1];
                    boolean upAndDown = arr[i - 1][j] < arr[i][j] && arr[i][j] > arr[i + 1][j];
                    if (leftAndRight && upAndDown) {

                        count ++;
                    }
                }
            }

        }

        return count;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] arr = new int[n+2][n+2];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = scanner.nextInt();
            }

        }
        System.out.println(solution(n, arr));

    }
}
