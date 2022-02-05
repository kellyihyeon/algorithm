package section05.section0504;

import java.util.Scanner;
import java.util.Stack;

/**
 * 후위 연산식(postfix)이 주어진다. 식은 1~9까지의 숫자와 +-*'/'
 * 후위 연산식이 주어졌을 때 이를 연산한 결과를 출력하라.
 *
 *     반복 ->3.다시 돈다. 1을 한다.
 *           4.2를 한다. '*' -> 스택에서 숫자(a)를 pop 한다. 숫자(b)를 하나 더 pop 한다. sum = b 연산자 a 하고, sum 을 stack 에 넣는다.
 *           *** sum 을 stack 에 넣지 않고 풀면 연산자가 나왔을 때 stack 에서 숫자(b)를 pop 하면 경우의 수가 2가지가 생긴다.
 *           *** 경우의 수 2가지: 스택에 숫자(b)를 pop 할 때 stack 에 남아있는 숫자가 있으면 sum = b 연산자 a
 *                                                              남아있는 숫자가 없으면 sum = a 연산자 sum
 *           *** 남아있는 숫자가 없을 때 'sum = a 연산자 sum' 이 계산식을 수행하면 결과 값이 달라진다. 2가 나와야하는데 -2가 나온다든지, 반대가 나온다든지.
 *
 * 연산자를 일일이 확인해서 연산 로직을 해주는 거 말고 다른 방법은 없나?
 * 메소드 분리하는 게 속도가 더 빠르네?
 */

//
public class Main {

    private int solution(String postfix) {
        // 3*(5+2)-9 -> postfix = 352+*9-
        int answer = 0;
        String expression = "+-*/";
        Stack<Integer> stack = new Stack<>();
        int a = 0;
        int b = 0;

        // 연산 순서: 1.연산자가 아니면 숫자를 스택에 쌓아둔다. [352
        //          2.연산자가 나오면 '+' -> 스택에서 숫자(a)를 pop 한다. 숫자(b)를 하나 더 pop 한다. b 연산자 a를 연산해서 sum 에 넣는다.
        //             sum 을 stack 에 넣는다.
        for (char character : postfix.toCharArray()) {
            // String 을 어떻게 숫자와 연산자로 분리할 것인가? -> char 로 뜯어서 array 를 만들고 char 가 expression 인지 확인한다.
            if (expression.contains(String.valueOf(character))) {
                a = stack.pop();
                b = stack.pop();
                answer = getAnswer(a, b, character);
                stack.push(answer);
            } else {
                stack.push(Integer.parseInt(String.valueOf(character)));
            }
        }

        return answer;
    }

    private int getAnswer(int a, int b, char c) {
        int sum = 0;

        if (c == '+') {
            sum = b + a;
        } else if (c == '-') {
            sum = b - a;
        } else if (c == '*') {
            sum = b * a;
        } else {
            sum = b / a;
        }

        return sum;
    }


    public static void main(String[] args) {
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);

        String postfix = scanner.nextLine();
        System.out.println(M.solution(postfix));
    }

}
