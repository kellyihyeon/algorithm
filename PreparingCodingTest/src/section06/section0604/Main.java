package section06.section0604;

import java.util.*;

// 캐시 크기 s, 수행해야 할 작업 n개가 주어질 때, n개의 작업을 수행한 후 캐시 메모리의 상태를 출력하라.
// 캐시 메모리는 LRU 알고리즘을 따라 작업을 수행한다.
// LRU 알고리즘: 가장 최신에 사용한 것이 배열 제일 앞에 위치한다.
// 수행해야 할 작업이 캐시 메모리에 없다면: Cache Miss 상태 - 수행할 작업을 맨 앞에 배치시키고 캐시 메모리를 한칸씩 민다. 맨 뒤에 있던 작업은 삭제된다.
// 수행해야 할 작업이 캐시 메모리에 있다면: Cache Hit 상태 - 수행할 작업을 맨 앞으로 옮기고 캐시 메모리를 한칸씩 민다. 위치만 바뀐다. 사라지는 작업은 없다.

// *** 보완: List 가 아닌 배열로 직접 구현해 푸는 방법을 배움.
public class Main {


    // List 로 풀었던 코드
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

    // 문제의 의도대로 배열을 사용해서 한칸씩 미는 로직 구현
    private int[] solution2(int s, int n, int[] task) {
        int[] memory = new int[s];
        // 작업이 메모리에 있다? 없다?
        // 작업이 메모리에 있는지 검사: 있으면 position = j (0~4). 없으면 position = -1
        for (int i = 0; i < n; i++) {
            // *** 실수: i가 증가해서 로직을 돌 때 position 을 다시 리셋해주지 않으면 if(position != -1) 이 루프로 계속 들어가므로 오답이 나온다.
            int position = -1;
            // 어떻게 판단? task[i]가 메모리에 있는지 for 문을 돌려서 확인한다.
            for (int j = 0; j < s; j++) {
                if (task[i] == memory[j]) {
                    position = j;
                    // *** 놓친점: 작업이 메모리에 이미 있음을 발견했으면 굳이 남아있는 작업을 뒤질 필요가 없으므로 break 해준다.
                    break;
                }
            }

            // 작업이 메모리에 있으면? -> position 이 j(0부터 4까지 숫자)범위인지 확인해야 해.
            if (position != -1) {
                // j는 position 부터 -- 해나간다: j가 1일때까지(j>0) 메모리[0]에는 작업을 넣어야 한다.
                for (int j = position; j > 0; j--) {
                    memory[j] = memory[j - 1];
                }

                // 작업이 메모리에 없으면?
            } else {
                // 작업을 맨 앞자리에 둘 거니까 메모리 맨 뒤에서부터 인덱스 1일때까지 원소를 하나씩 복사하면서 옮겨 놓는다.
                // 인덱스 i 자리에 인덱스 i-1 해서 숫자를 옮겨 놓는다. -> for 문을 돌려서 인덱스가 0이면 앞이 없으니까 인덱스는 0보다 커야 한다.
                for (int j = s - 1; j > 0; j--) {
                    memory[j] = memory[j - 1];
                }
            }

            //*** 놓친점: 작업이 메모리에 이미 있든, 없든 메모리의 0번째에는 해당 작업을 넣는 행위는 공통되므로 코드를 if-else 문 밖으로 빼서 중복 작업을 줄임.
            memory[0] = task[i];

        }
        return memory;
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

        for (int i : M.solution2(s, n, task)) {
            System.out.print(i + " ");
        }
    }
}
