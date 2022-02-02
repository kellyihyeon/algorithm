package section04.section0405;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Answer {

    private int solution(int n, int k, int[] arr) {
        int answer = -1;
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    treeSet.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        System.out.println("treeSet 의 제일 처음 값은? = " + treeSet.first());
        System.out.println("treeSet 의 제일 마지막 값은? = " + treeSet.last());
        int cnt = 0;
        for (Integer integer : treeSet) {
            cnt++;
//            System.out.println(cnt + " - " + integer);
            if (cnt == k) {
                return integer;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Answer M = new Answer();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(M.solution(n, k, arr));
    }
}
