package section05;

import java.util.Scanner;
import java.util.Stack;

/**
 * stack 으로 풀기
 */
public class Answer {

    private String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else {
                if (stack.isEmpty()) {
                    return "NO";    // 바로 return 해주니까 else 분기문을 적을 필요가 없네
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            return "NO";
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
