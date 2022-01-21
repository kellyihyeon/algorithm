package section03.section0302;

import java.time.LocalDateTime;
import java.util.*;

public class Main {

    private List<Integer> solution(int n, int m, List<Integer> listA, List<Integer> listB) {
        // 2. two pointer 활용하기: 생각하자 !!!
        //      A와 B를 먼저 오름차순으로 정렬을 하면?
        //      A와 B가 오름차순으로 정렬이 된 상태면 pointer 를 이용해 A 첫번째 원소를 B의 각 원소와 비교하면서 새로운 배열에 오름차순 된 원소를 넣을 수 있다.

        List<Integer> answer = new ArrayList<>();
        int pointerA = 0;
        int pointerB = 0;

        // listA 와 listB 를 각각 이중 for 문을 돌려서 오름차순으로 정렬한 게 Time Limit Exceeded 가 뜬 원인인 것 같다.
        // Time Limit Exceeded -> for 문 돌려서 n과 m의 최악의 경우의 수만 해도 30,000 * 30,000
        //  -> sort 메소드 이용하면 속도가 얼마나 빨라지는 걸까?
        //  -> 전: 2022-01-21T16:28:51.572 -> 후: 2022-01-21T16:28:51.577

        Collections.sort(listA);
        Collections.sort(listB);

        while (pointerA < listA.size() && pointerB < listB.size()) {
            if (listA.get(pointerA).equals(listB.get(pointerB))) {
                answer.add(listA.get(pointerA));
                pointerA++;
                pointerB++;
            }else {
                if (listA.get(pointerA) < listB.get(pointerB)) {
                    pointerA++;
                } else {
                    pointerB++;
                }
            }

        }

        return answer;
    }

    private void checkToTimeForCollectionsSortMethod(List<Integer> listA, List<Integer> listB) {
        System.out.println("sort 메소드 실행 전 = "+ LocalDateTime.now());    // 2022-01-21T16:28:51.572
        Collections.sort(listA);
        Collections.sort(listB);
        System.out.println("sort 메소드 실행 후 = "+ LocalDateTime.now());    // 2022-01-21T16:28:51.577
    }

    private void checkToTimeForSortToAscMadeByMe(int n, int m, List<Integer> listA, List<Integer> listB) {
        // 엄청 느리다. Time Limit Exceeded 나올만하다.
        System.out.println(" asc 직접 하는 메소드 실행 전 = " + LocalDateTime.now());     // 2022-01-21T16:27:08.846
        ascToLists(n, m, listA, listB);
        System.out.println(" asc 직접 하는 메소드 실행 후 = " + LocalDateTime.now());     // 2022-01-21T16:27:29.137
    }

    // Collections.sort() 를 해도 이 메소드 내부에서 Arrays.sort() 메소드를 호출한다.
    private void ascToLists(int n, int m, List<Integer> listA, List<Integer> listB) {
        // A 오름차순
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

        // B 오름차순
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
    }

    // Time Limit Exceeded 나온 코드 (pointer 활용 못한 코드)
    private void timeLimitExceededCode1(List<Integer> listA, List<Integer> listB, List<Integer> answer, int pointerA, int pointerB) {
        // A 의 첫 번째 원소 1과 B의 각 원소를 비교 (나와 같은 숫자가 있는지 검사) -> 없으면? A의 해당 원소 제거 (while 문으로 계속 돌아간다고 가정)
        // A 배열의 원소는 B의 각 원소와 같든 다르든 제거한다. pointerA 는 항상 A 배열의 원소 0 인덱스를 가리킨다.
        // -> pointer 를 활용하지 못한 게 패인.
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
