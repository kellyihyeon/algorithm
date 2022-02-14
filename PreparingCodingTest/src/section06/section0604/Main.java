package section06.section0604;

import java.util.*;

// 캐시 크기 s, 수행해야 할 작업 n개가 주어질 때, n개의 작업을 수행한 후 캐시 메모리의 상태를 출력하라.
// 캐시 메모리는 LRU 알고리즘을 따라 작업을 수행한다.
// LRU 알고리즘: 가장 최신에 사용한 것이 배열 제일 앞에 위치한다.
// 수행해야 할 작업이 캐시 메모리에 없다면: Cache Miss 상태 - 수행할 작업을 맨 앞에 배치시키고 캐시 메모리를 한칸씩 민다. 맨 뒤에 있던 작업은 삭제된다.
// 수행해야 할 작업이 캐시 메모리에 있다면: Cache Hit 상태 - 수행할 작업을 맨 앞으로 옮기고 캐시 메모리를 한칸씩 민다. 위치만 바뀐다. 사라지는 작업은 없다.
public class Main {


    private int[] solution(int s, int n, int[] task) {
        int[] result = new int[s];
        // 수행해야 할 작업을 하나씩 읽는다.
        // task[0]번부터 차례대로 읽는다. 다음 작업을 읽고 맨 앞에 둬야 하는데 어떻게 쌓을까??? -> List 를 이용해서 0번째에 원소를 추가한다.

        // 접근 방법 자체를 모르겠으니까 list 써서 해보자.
        // 공통으로 처리할 방식은 list.add(0, task[?])
        List<Integer> memory = new ArrayList<>();   // 3 2 1
        for (int i = 0; i < n; i++) {   // s-메모리 크기, n-작업량
            // 작업을 읽고 해당 작업이 memory 에 있는지 확인한다. (캐시메모리)
            if (memory.contains(task[i])) {
                // 메모리에 있으면 해당 위치의 작업은 제거하고 0번째로 보내야 한다.
                int removeIndex = memory.indexOf(task[i]);
                memory.remove(removeIndex);     // *** 인덱스를 넣어야 해당 인덱스에 해당하는 원소를 삭제. 원소를 바로 넘겨서 잘못된 원소를 삭제하는 실수를 함.

            }
            // 메모리에 있든 없든 작업을 memory 0번째에 넣는다.
            memory.add(0, task[i]);
        }

        for (int i = 0; i < s; i++) {
            result[i] = memory.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);

        int s = scanner.nextInt();
        int n = scanner.nextInt();
        int[] task = new int[n];
        for (int i = 0; i < n; i++) {
            task[i] = scanner.nextInt();
        }

        for (int i : M.solution(s, n, task)) {
            System.out.print(i + " ");
        }
    }
}
