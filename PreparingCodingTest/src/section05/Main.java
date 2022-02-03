package section05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    private String solution(String str) {
        String answer = "NO";
        // 괄호가 올바른 한쌍으로 이루어져있는지 판단해야한다.
        // 여는 괄호 '(' 는 닫는 괄호 ')'를 만나야만한다. 여는 괄호가 2개가 있다면 닫는 괄호도 2개가 있어야만한다는 의미이다.
        // 단순히 갯수만 맞아야 하는 게 아니라 한쌍이 되는 것이 포인트이다. 여는 괄호는 닫는 괄호를 만나지 못하고 끝나면 올바른 한쌍이 될 수 없다.
        // * 괄호는 여는 괄호로 시작되고 닫는 괄호는 여는 괄호 없이 시작될 수 없다.

        // 배열에 괄호 저장하기
        List<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }


        // 이중 포문을 돌면서, 여는 괄호가 닫는 괄호를 만나는지 체크한다. 한쌍이 되었으면 괄호 한쌍을 제거해야한다.
        // 괄호를 제거하면 시작하는 인덱스는 항상 0이 되야 되므로 포인터를 이용한다.
        int pointer = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 1; j < str.length(); j++) {
                // 핵심은 전부 짝을 이뤄서 다 제거되면 YES = 사이즈가 0이면 된다.
                // *** 포문을 돌 때 조건을 str 의 길이까지로 설정했으면 list 의 size 가 0 일 때 가 중요하다.
                //      list 의 인덱스에 접근하면 인덱스 범위 예외가 생기므로 0일 때 YES 가 되고 다른 분기문을 시작하지 않도록 설정해야 한다.
                if (list.size() == 0) {
                    answer = "YES";
                    // 포인터는 여는 괄호, j는 닫는 괄호니까 조건에 맞았을 때 포인터 값과 j 값을 배열에서 제거한다.
                } else if (list.get(pointer) == '(') {
                    if (list.get(j) == ')') {
                        list.remove(pointer);
                        // *** 이때 j의 인덱스는 -1을 해줘야 한다. 맨 앞의 0번 인덱스가 제거 될 때 사이즈가 줄어서 인덱스도 한 칸씩 줄기 때문에
                        list.remove(j - 1);
                        break;
                    }
                } else {
                    return answer;
                }
            }
        }

        return answer;
    }

    /**
     * stack 으로 풀기. stack 은 last in first out
     */
    private String solutionUsingStack(String str) {
        String answer = "YES";
        // str 에서 문자를 뽑고, 문자가 여는 괄호라면 stack 에 저장한다.
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                // stack 에서 문자를 빼야 하는데 stack 이 비어있다면? 잘못된 괄호이므로 NO를 출력한다.
                if (stack.isEmpty()) {
                    answer = "NO";
                } else {
                    // 문자가 닫는 괄호라면 stack 에서 문자를 뺀다.(pop)
                    stack.pop();
                }
            }
        }
        // 문자를 전부 검사하고나서 stack 이 비어있다면 짝 맞게 비어진 것이므로 YES 를 출력한다.
        if (!stack.isEmpty()) {
            answer = "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        // 괄호 문자열이 입력된다. (최대 길이: 30)
        // 이 괄호가 올바른 한쌍으로 이루어져있으면 YES, 그렇지 않으면 NO를 출력하라.
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        System.out.println(M.solutionUsingStack(str));
    }
}
