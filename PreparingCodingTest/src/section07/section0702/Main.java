package section07.section0702;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 재귀 함수
 * 10진수 n이 입력되면 2진수로 변환하여 출력하라.
 * (1 <= n <= 1,000)
 * -> 재귀 함수를 이용하지 않고 출력
 */
public class Main {


    private List<Integer> solution(int n) {
        List<Integer> answer = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        // n = 11 -> output: 1011
        // 11 이 1101 로 출력되는 이유?
        // 2진수 = 2^0, 2^1, 2^2, 2^3...
        // 1 2 4 8 16 32 64 128...
        // n 을 비교하며, 제곱을 몇번까지 해야 하는지 결정한다. -> 2의 10승이 1024.
        for (int i = 0; i < 10; i++) {
            int pow = (int) Math.pow(2, i);
            // *** stack 에 최소 4개의 수는 담아놔야 한다.(1 2 4 8)
            // n이 9보다 작아도 1 2 4 8 은 스택에 담아야 한다.
            if (9 > pow || pow < n) {
                stack.push(pow);
            }

        }

        // 8 더하고 n과 비교, 4 더하고 n과 비교 n을 초과하므로 1로 만들지 않고, 2더하고 비교, 1더하고 비교, 더한 값이 n이면 이 때 1과 0으로 된 배열 출력
        int sum = 0;
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            sum += pop;
            if (sum <= n) {
                answer.add(1);
            } else {
                answer.add(0);
                sum -= pop;
            }
        }


        return answer;
    }



    public static void main(String[] args) {
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for (Integer integer : M.solution(n)) {
            System.out.print(integer);
        }

    }
}
