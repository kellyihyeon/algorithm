package section05.section0508;

import java.util.*;

// n 명의 환자 대기목록 수가 주어지고 환자의 대기번호 m 이 주어진다.
// 그리고 환자의 위험도가 배열 arr 로 주어진다. (위험도: 50 ~ 100이고, 숫자가 클수록 위험도가 높다)
// 환자 n명 중 대기번호 m 인 환자의 진료 순서를 구해야한다. (환자의 대기번호는 0번부터 시작한다.)
// 대기 순서대로 진료가 이루어지는데 대기번호 m 환자는 자기 차례에 자기보다 위급한 환자가 없다면 진료를 받고 그렇지 않다면 진료 순서가 밀려난다.
// 문제에서 제시한 진료순서 정하는 방법
// 1. 대기 순서 제일 앞에 있는 환자를 꺼낸다.
// 2. 나머지 대기 목록을 살펴본다.
// 3. 이 환자보다 위험도가 높은 환자가 존재하면 이 환자를 대기목록 제일 뒤로 넣는다.
// 4.                            존재하지 않으면 이 환자는 진료를 받는다.

// *** 문제에서 제시한 방법(제일 첫번째 환자를 맨 뒤로 보내서 풀어야 되는 것 같은데)대로 풀지는 않았음.

// 6 0
// 60 60 90 60 60 60  -> answer = 5;
// 납득이 안가네. 제일 처음 온 환잔데 왜 위급 환자 90 다음에 진료를 받을 수 없는 거지?? 2번째가 돼야 맞는 거 아닌가?????
// 이래서 맨 뒤로 보내라고 한 거구나. 상식대로 진료 보는 게 아니니까.
public class Main {

    // 문제 이해 잘못해서 오답. (문제 이해 못하고 상식적인 진료 순서처럼 품)
    private int solution(int n, int m, int[] arr) {
        int answer = 1;     // answer 은 order 를 나타냄.
        Queue<Integer> queue = new LinkedList<>();
        for (int i : arr) {
            queue.offer(i);
        }
        
        int target = arr[m];    
        for (int i = 0; i < arr.length; i++) {  // *** 조건을 queue.size() 로 잡는다면? queue 는 사이즈가 계속 줄어들어서 i 가 배열의 원소 끝까지 돌지 못하고 끝난다.
            // poll 값과 타겟을 비교. 타겟이 작으니까 우선 순위가 하나 밀려난다. order++ -> (order = 2)
            Integer poll = queue.poll();
            if (poll > target) {
                answer++;
            } else if (poll == target) {
                //                     타겟과 같은 수이지만 1.타겟보다 먼저 왔으므로 우선 순위 밀림 order++ -> (order = 3)
                //                                       기준은? i 값이 m 보다 작으면 (i < m) 먼저 온 같은 수 -> order ++
                //                                              i 값이 m 보다 크거나 같으면 (i >= m) 아무것도 안한다.
                if (i < m) {
                    answer++;
                }
                //                                       2.타겟이 먼저 왔다면? order 손보지 않고 그냥 넘어가면 된다.
            }
            //                       타겟이 큰 수면? 먼저 들여보내지 않아도 되니까 order 에 손대지 않는다. -> 제일 크다면 결국 order 는 1이된다.
        }
        // 결론: poll 이 target 보다 클 때는 order++, 같으면 i 값이 m 보다 작을 때만 order++
        return answer;
    }


    public static void main(String[] args) {
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(M.solution(n, m, arr));

    }

    private class Patient {
        private int id;
        private int priority;

        public Patient(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }

        public int getId() {
            return id;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public String toString() {
            return "Patient{" +
                    "id=" + id +
                    ", priority=" + priority +
                    '}';
        }
    }
}
