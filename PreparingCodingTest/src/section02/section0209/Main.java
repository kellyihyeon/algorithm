package section02.section0209;

import java.util.Scanner;

public class Main {

    private static int solution(int n, int[][] arr) {
        int diagonal1 = 0;
        int diagonal2 = 0;
        int rowMax = 0;
        int columnMax = 0;

        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            int columnSum = 0;

            for (int j = 0; j < n; j++) {
                rowSum += arr[i][j];
                columnSum += arr[j][i];
                if (i == j) {
                    diagonal1 += arr[i][j];
                } else if (j == 4 - i) {
                    diagonal2 += arr[i][j];
                }
            }
            if (rowMax < rowSum) {
                rowMax = rowSum;
            }
            if (columnMax < columnSum) {
                columnMax = columnSum;
            }
        }

        int[] nums = {rowMax, columnMax, diagonal1, diagonal2};
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(solution(n, arr));
    }

}
