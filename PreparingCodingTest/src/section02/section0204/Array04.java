package section02.section0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array04 {
    public static int[] solution(int n) {
        int[] pivo = new int[n];
        pivo[0] = 1;
        pivo[1] = 1;

        for (int i = 3; i < n + 1; i++) {   // n = 3
            pivo[i - 1] = pivo[i - 2] + pivo[i - 3];
        }

        return pivo;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i : solution(n)) {
            System.out.print(i + " ");
        }
    }
}
