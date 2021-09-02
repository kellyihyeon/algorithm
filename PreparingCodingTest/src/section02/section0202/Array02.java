package section02.section0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Array02 {
    public static int solution(int n, int[] arr) {
        List<Integer> list = new ArrayList<>();
        int max = arr[0];
        list.add(max);

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                list.add(max);
            }
        }

        return list.size();

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        System.out.println(solution(n, arr));

    }
}
