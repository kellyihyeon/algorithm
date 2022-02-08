package section05.section0506;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// 공주를 구하러 가길 원하는 사람의 수 n 이 주어지고, 이 사람들을 1 ~ n까지 순서대로 시계 방향으로 앉힌다. 1 2 3 4 ~ n
// 1번부터 순서대로 1부터 시작해 번호를 외치게 하는데 이 때 k를 외치는 사람은 공주를 구하러 가는 데서 제외되고 밖으로 나와야한다.
// 다음 순서였던 사람부터 다시 1부터 시작해 번호를 외친다. 한 명이 남을 때까지 이를 반복하는데, 남은 한명이 공주를 구하러 갈 수 있다. 이 한명의 번호를 출력하라.

// *** queue 를 몰라서 stack 2개로 풀었는데, queue 로 푸는 게 시간이 단축된다.
// 풀이 코드가 진짜 깔끔하니까 참고 할 것 !
public class Main {

    // queue 로 풀기
    private int solution2(int n, int k) {
        int answer = 0;
        // queue 의 사이즈가 1일 때까지 while 문 돌리고
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i + 1);    // insert. 사이즈 제한 있음
        }

        int count = 1;
        int element = 0;
        while (queue.size() != 1) {
            // queue 의 첫번째 값을 계속 꺼낸다.
            element = queue.poll();
            // 카운트가 k가 아니라면 첫번째에 있던 값을 queue 맨 뒤에 가져다 놓는다.
            if (count != k) {
                queue.offer(element);  // insert
                count++;    // 3
                // 카운트가 k 가 되면 다음 순서부터 다시 1을 위쳐야 하므로 카운트는 리셋한다.
            } else {
                count = 1;
            }
        }
        answer = queue.peek();

        return answer;
    }

    // queue 몰라서 stack 2개로 풀었음
    private int solution(int n, int k) {
        int answer = 0;
        // stack 에 담으면서 카운트와 k를 비교해서 count == k 가 같은 경우에 해당하는 사람을 제외시킨다.
        Stack<Integer> stack = new Stack<>();
        // 우선 스택에 저 사람들을 넣어놓는다.
        Stack<Integer> fullStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            fullStack.add(i + 1);
        }

        int count = 1;
        boolean isContinue = true;  // while 문의 조건을 설정하는 다른 방법이 있을까?

        while (isContinue) {
            for (int i = 0; i < fullStack.size(); i++) {
                // 스택에 담을 때마다 카운트는 ++ 되고
                if (count != k) {   // 1
                    stack.push(fullStack.get(i));
                    count++;
                    // 만약 카운트와 k가 같다면 담지 않는다. 그리고 카운트는 1로 리셋한다.
                } else {
                    count = 1;
                }
            }
            // 스택의 사이즈가 1이 아닐 때(지원자가 여러명인 경우) 스택도 리셋하고 작업을 반복한다.
            if (stack.size() != 1) {
                // 초기 지원자들을 담은 풀스택은 리셋한다.
                fullStack.clear();
                // 추려낸 지원자들(스택)을 다시 풀스택에 옮겨 담는다.
                fullStack = (Stack<Integer>) stack.clone();
                // 스택은 지원자들을 다시 추려내야 하기 때문에 리셋해준다.
                stack.clear();
            } else {
                // 지원자가 한명으로 추려졌을 때는 작업을 끝낸다.
                isContinue = false;
                answer = stack.pop();
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(M.solution(n, k));
    }
}
