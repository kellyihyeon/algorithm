package section10.section1005;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int[] dy;

    private int solution(Integer[] coins, int charge) {
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= charge; j++) {
                dy[j] = Math.min(dy[j], dy[j - coins[i]] + 1);
            }
        }

        return dy[charge];
    }


    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Integer[] coins = new Integer[n];

        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        int charge = scanner.nextInt();

        dy = new int[charge + 1];

        System.out.println(M.solution(coins, charge));
    }

}
