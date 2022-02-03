package section05.section0502;

import java.util.*;

public class Main {

    private List<Character> solution(String str) {
        List<Character> answer = new ArrayList<>();
        // (A(BC)D) EF(G (H )(IJ )K )LM(N )
        // 소괄호가 주어지니까 닫는 괄호부터 나오는 건 없다고 가정해보자.
        Stack<Character> stack = new Stack<>();
        for (char character : str.toCharArray()) {
            // 문자가 )가 아니라면 스택에 넣는다.
            if (character != ')') {
                stack.push(character);
                // 문자가 )라면, 스택에 담겨 있는 문자가 (일때까지 제거한다.
            } else {
                // peek 해서 문자를 꺼내보고 ( 앞 문자까지 제거
                while (stack.peek() != '(') {
                    stack.pop();
                }
                // (도 제거한다. 마지막 문자까지 반복한다. -> peek 메서드를 이용한다.
                stack.pop();
            }

        }
        // 스택에 남아 있는 문자를 출력한다.
        while (!stack.isEmpty()) {
            answer.add(stack.pop());
        }
        // stack 에 ABCD 가 저장돼있을 때 pop 을 하면 DCBA 순으로 나온다.(Last in First out) -> 역순으로 정렬한다.
        Collections.reverse(answer);

        // 알게된 것: stack 도 for each 문 써서 배열처럼 접근하면 0번부터 뽑을 수 있다. -> pop 으로 안뽑아도 된다.

        return answer;
    }

    public static void main(String[] args) {
        // 입력된 문자열에서 괄호 사이에 존재하는 모든 문자를 제거하고, 남아 있는 문자만 출력하라.
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        for (Character character : M.solution(str)) {
            System.out.print(character);
        }
    }
}
