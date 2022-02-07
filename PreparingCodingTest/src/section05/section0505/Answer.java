package section05.section0505;

import java.util.Scanner;
import java.util.Stack;

public class Answer {

    private int solution(String str) {
        // 여는 괄호를 만나면 무조건 stack 에 push.
        // 닫는 괄호를 만나면
        // 1. 레이저의 닫는 괄호인지
        // 2. 막대기의 닫는 괄호인지
        //  *** 레이저의 닫는 괄호든 막대기의 닫는 괄호든 자기의 짝꿍인 여는 괄호는 stack 에서 빼버려야한다.
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else {
                stack.pop();
                if (str.charAt(i - 1) == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Answer M = new Answer();
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        System.out.println(M.solution(str));
    }
}
