package section05.section0505;

import java.util.Scanner;
import java.util.Stack;

/**
 * // 쇠막대기와 레이저의 배치를 나타내는 괄호가 문자열로 주어진다. (공백 없음, 최대 100,000)
 *         // () 이렇게 인접하게 여는 괄호, 닫는 괄호가 만나는 표시는 레이저이다. 쇠막대기의 길이는 (   ) 로 표시된다.
 *         // 괄호 한쌍이 인접하면 그 표시는 레이저, 인접하지 않으면 쇠막대기.
 *         // 쇠막대기에 레이저를 쐈을 때 막대기가 몇 개로 잘려지는지 출력하라.
 *
 */
public class Main {

    private int solution(String deployment) {
        int answer = 0;
        Stack<String> stack = new Stack<>();
        final char[] parenthesis = deployment.toCharArray();

        for (int i = 0; i < deployment.length(); i++) {
            // 여는 괄호를 만나면 stack 에 집어 넣는다.
            if (parenthesis[i] == '(') {
                stack.push(String.valueOf(parenthesis[i]));
                // 닫는 괄호를 만나면 -> 1.레이저이다. 2.막대기이다. / 두 가지 경우의 수가 생긴다.
            } else {
                //          -> 닫는 괄호를 만나면 바로 앞의 괄호가 무엇인지 살펴본다.
                //          for 문으로 루프가 돌아갈 때 deployment 의 i-1 인덱스 값이 '(' 면 레이저, ')' 면 막대기이다.
                // 이전 괄호가 레이저든 막대기든, stack 에서 pop 을 한다.
                stack.pop();
                if (parenthesis[i - 1] == '(') {
                    // stack 에서 pop 을 해서 레이저의 여는 괄호를 없애고 stack 에 남아 있는 막대기 개수만큼 막대기를 자른다.
                    // 스택에 막대기가 3개가 있다면 레이저를 만났을 때 세 조각이 난다. sum 에 stack 의 사이즈를 더한다. (sum = 3)
                    answer += stack.size();
                } else {
                    // ) 를 만나면 막대기 하나의 길이가 끝났다는 의미이므로 stack 에서 pop 해서 막대기를 회수하고, 막대기의 나머지 한 조각을 sum 에 더해줘야 한다. (sum = 7)
                    answer += 1;
                }

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);

        String deployment = scanner.nextLine();
        System.out.println(M.solution(deployment));
    }
}
