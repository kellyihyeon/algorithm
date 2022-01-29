package section04.section0403;

import java.util.*;

public class Main {

    private List<Integer> solution(int n, int k, int[] arr) {
        // n일 동안의 매출기록이 주어졌을 때 k일 동안의 매출액을 map 에 담는다.
        // map 의 key 가 매출액이 된다. k가 4라면 map 에 담는 key 도 최대 4개이다.
        // 예를 들어 매출액 종류가 다르다면 10, 20, 34, 50 -> 각각을 key 로 해서 map 에 담는다. 매출액의 종류는 map 의 사이즈이다.

        // 설정: 1.여기서 처음 key 와 마지막 key 를 알려줄 포인터가 필요하다.
        //      2. 언제까지 한칸씩 땡겨 가야 하는가? 마지막 인덱스를 가리킬 포인터가 n-1 과 같을 때 멈춘다.
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        int lt = 0;

        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        answer.add(map.size());

        // 다음이 문제인데 처음 key 가 map 에 있는지 확인하고 <- lt 에 해당하는 key 는 map 에 존재한다. 애초에 k 까지 map 에 담았기 때문에
        // 있으면 value 를 확인한다. value 가 1이면(자기자신만 존재) 해당 key 를 map 에서 제거하고 아니면 -1을 한다.
        for (int rt = k; rt < n; rt++) {
            if (map.get(arr[lt]) == 1) {
                map.remove(arr[lt]);
            } else {
                map.put(arr[lt], map.get(arr[lt]) - 1);
            }
            lt++;
            // 다음에 담을 key(마지막 key)가 map 에 있는지 확인하고 있으면 value 를 +1, 없으면 새로 key 를 만들어 담는다.
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer.add(map.size());

        }

        return answer;
    }

    public static void main(String[] args) {
        // n일 동안의 매출기록이 주어지고, 연속된 k일 동안의 매출액 종류를 구하라.
        // 매출액의 종류란 같은 숫자이면 한 종류로 분류된다.
        // 사용자 입력 받기
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (Integer num : M.solution(n, k, arr)) {
            System.out.print(num + " ");
        }
    }
}
