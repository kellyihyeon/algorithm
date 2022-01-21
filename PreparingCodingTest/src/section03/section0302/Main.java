package section03.section0302;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private List<Integer> solution(int n, int m, List<Integer> listA, List<Integer> listB) {
        // 2. two pointer 활용하기: 생각하자 !!!
        //      A와 B를 먼저 오름차순으로 정렬을 하면?
        //      A와 B가 오름차순으로 정렬이 된 상태면 pointer 를 이용해 A 첫번째 원소를 B의 각 원소와 비교하면서 새로운 배열에 오름차순 된 원소를 넣을 수 있다.

        // Time Limit Exceeded -> for 문 돌려서 n과 m의 경우의 수만 해도 30,000 * 30,000

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                int tmp = 0;
                if (listA.get(j) > listA.get(j + 1)) {
                    tmp = listA.get(j);
                    listA.set(j, listA.get(j + 1));
                    listA.set(j + 1, tmp);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m - 1; j++) {
                int tmp = 0;
                if (listB.get(j) > listB.get(j + 1)) {
                    tmp = listB.get(j);
                    listB.set(j, listB.get(j + 1));
                    listB.set(j + 1, tmp);
                }
            }
        }

        // A 의 첫 번째 원소 1과 B의 각 원소를 비교 (나와 같은 숫자가 있는지 검사) -> 없으면? A의 해당 원소 제거 (while 문으로 계속 돌아간다고 가정)
        // A 배열의 원소는 B의 각 원소와 같든 다르든 제거한다. pointerA 는 항상 A 배열의 원소 0 인덱스를 가리킨다.
        int pointerA = 0;
        int pointerB = 0;
        while (!listA.isEmpty()) {
            if (pointerB < listB.size()) {
                if (listA.get(pointerA).equals(listB.get(pointerB))) {
                    answer.add(listA.get(pointerA));
                    listA.remove(pointerA);
                    listB.remove(pointerB);
                } else {
                    pointerB++;
                }
            } else {
                listA.remove(pointerA);
                pointerB = 0;
            }


        }

        return answer;
    }

    public static void main(String[] args) {
        // 2개의 집합이 주어지면 공통 원소를 찾고 이를 오름차순으로 정렬해서 출력하라.
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> listA = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listA.add(scanner.nextInt());
        }

        int m = scanner.nextInt();
        List<Integer> listB = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            listB.add(scanner.nextInt());
        }

        for (Integer num : M.solution(n, m, listA, listB)) {
            System.out.print(num + " ");
        }

    }

}
