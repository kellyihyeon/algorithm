package section04.section0405;

import java.util.*;

/**
 * 놓친 점
 * 1. 경우의 수를 찾기 전: list 를 내림차순. list.sort(Collections.reverseOrder()); // 굳이 안해도 되네 어차피 set 에 담을 때 순서 보장이 안되는데
 * 2. Runtime Error: k번째 수가 존재하지 않는 경우에 -1을 반환하는 조건의 로직을 짜지 않아서 발생
 */
public class Main {

    private int solution(int n, int k, List<Integer> list) {
        int answer = -1;
        // 큰 수의 합이 같다면 하나로 치고 k번째 수를 구해야 하므로, 합이 같은 수가 몇개가 나올지 모르기 때문에 경우의 수는 다 구해야 한다.
        // (k번째 수가 존재하지 않으면 -1을 출력해야하기 때문)

        // 경우의 수 찾기
        // lt, mt, rt 이용. lt는 0부터, mt는 lt+1부터, rt는 mt+1부터 해서 중복 기록하는 수가 없게 한다.
        // 경우의 수를 기록한 데이터 -> 1.저장할 때 아예 중복 안되게 저장할 건지(set), 2.저장은 중복되게 할 건지(map, list)? -> value 값이 필요없으므로 map 은 필요 없다.
        // HashSet 은 정렬도 안되고, 순서도 랜덤이다. -> list 에 담아서 내림차순 정렬.
        Set<Integer> set = new HashSet<>();
        for (int lt = 0; lt < n; lt++) {
            for (int mt = lt + 1; mt < n; mt++) {
                for (int rt = mt + 1; rt < n; rt++) {
                    // set 에 넣으면 중복될 때 무시되므로 바로 k-1번째를 출력하면 된다.
                    set.add(list.get(lt) + list.get(mt) + list.get(rt));
                }
            }
        }

        // 내림차순 정렬을 위해 set -> list 에 담고 정렬한다.
        List<Integer> setToList = new ArrayList<>(set);
        setToList.sort(Collections.reverseOrder());

        // 큰 수부터 정렬하였으므로 자료구조의 k-1 번째 값을 출력한다.
        // Runtime Error 원인:
        // k번째 수가 존재하지 않는 경우 -1을 출력해야 하므로 if 문으로 조건을 줘야한다. 조건 없이 k-1 번째 수를 출력하려하니 Runtime Error 발생.
        if (setToList.size() > k) {
            answer = setToList.get(k - 1);
        }


        return answer;
    }

    public static void main(String[] args) {
        // n 개의 카드 갯수, k 번째로 큰 수, n개의 카드 값 문자열이 주어진다. (같은 숫자 카드가 여러장 있을 수 있다.)
        // n 개의 카드 중 무작위로 3개를 뽑아 각 카드에 적힌 숫자를 합한 값을 기록한다.
        // 3장을 뽑을 수 있는 모든 경우의 수를 기록한다. 가장 큰 수 ~ 가장 작은 수. (내림차순) 이 중 k 번째로 큰 수를 출력하라.
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        System.out.println(M.solution(n, k, list));
    }
}
