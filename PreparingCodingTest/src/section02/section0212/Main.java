package section02.section0212;

import java.util.Scanner;

public class Main {

    private int solution(int n, int m, int[][] arr) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = 0;
                for (int k = 0; k < m; k++) {   // test 번호
                    int positionI = 0;
                    int positionJ = 0;
                    for (int l = 0; l < n; l++) {    // 등수 번호
                        if (arr[k][l] == i) {
                            positionI = l;
                        }
                        if (arr[k][l] == j) {
                            positionJ = l;
                        }
//                        System.out.print("| i= " + i + " j= " + j + " k= " + k + " l= " + l);
                    }

                    if (positionI < positionJ) {
                        cnt++;
                    }
                }

                if (cnt == m) {
                    answer++;
                }

            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();   // 학생수
        int m = scanner.nextInt();  // 시험 횟수
        int[][] arr = new int[m][n]; // arr[3][4]

        for (int i = 0; i < m; i++) {   // i=0,1,2
            for (int j = 0; j < n; j++) {    // j=0,1,2,3
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(M.solution(n, m, arr));
    }
}
