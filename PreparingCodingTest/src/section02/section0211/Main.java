package section02.section0211;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * list 를 안 비우고 계속 쌓아뒀었네 ㅠㅠ
 */
public class Main {

    public int solution(int n, int[][] arr) {
        int studentIndex = 1;
        int[] result = new int[n];
        List<Integer> done = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int matching = 0;
            done.clear();   // clear !!
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < n; k++) {
                    if (!done.contains(k) && arr[i][j] == arr[k][j]) {
                        done.add(k);
                        matching++;
                    }

                }//for3-k

            }//for2-j
            result[i] = matching;
        }//for1-i


        int max = result[0];
        for (int i = 1; i < result.length; i++) {
            if (max < result[i]) {
                max = result[i];
                studentIndex = i + 1;
            }
        }

        return studentIndex;
    }

    public static void main(String[] args) {
        final Main M = new Main();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] arr = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(M.solution(n, arr));
    }
}
