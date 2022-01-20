package section03.section0301;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private List<Integer> solution(int n, int m, int[] arr1, int[] arr2) {
        // 1. 첫번째 배열에 두번째 배열을 더해서 하나의 배열로 만든 다음에 이를 오름차순으로 정렬할까?
        // 2. 첫번째 배열과 두번째 배열의 첫번째 원소를 서로 비교해서 정렬을 하면?

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            list.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            list.add(arr2[i]);
        }

        // for 문을 돌려가면서, 다음 인덱스가 나보다 큰지 알아본다. -> 1 3 5 2 3 6 7 9
        // 2번째(5)에서 조건이 맞지 않다. 2는 5보다 크지 않다. 2와 5를 자리바꾼다. -> 1,3,2,5,3,6,7,9
        // 3번째(5)에서 조건이 맞지 않다. 5와 3을 자리 바꾼다. -> 1,3,2,3,5,6,7,9
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size()-1; j++) {
                int tmp = 0;
                if (list.get(j) >= list.get(j + 1)) {
                    tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        // 오름차순으로 정렬이 된 2개의 배열이 주어진다. 이 두 배열을 오름차순으로 정렬해서 합친 결과를 출력하라.
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = scanner.nextInt();
        }

        for (Integer answer : M.solution(n, m, arr1, arr2)) {
            System.out.print(answer + " ");
        }

    }
}
