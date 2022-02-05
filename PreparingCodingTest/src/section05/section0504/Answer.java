package section05.section0504;

import java.util.Scanner;
import java.util.Stack;

/**
 * 배운 것 2가지
 * 1. x 가 연산자인지 확인하는 것보다 x 가 숫자인지 확인하는 것이 더 효율적이고 읽기 쉬운 코드인 것 같다.
 * 2. 아스키 문자: '0'=48, '1'=49, '2'=50, '3'=51, '4'=52, '5'=53
 *    char '5'를 stack 에 넣으면 Integer 53 으로 들어가기 때문에 -48을 해줘서 숫자 5가 들어가게끔 해준다.
 */
public class Answer {

    private int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                stack.push(x - 48);
            } else {
                int rt = stack.pop();
                int lt = stack.pop();
                if (x == '+') {
                    stack.push(lt + rt);
                } else if (x == '-') {
                    stack.push(lt - rt);
                } else if (x == '*') {
                    stack.push(lt * rt);
                } else {
                    stack.push(lt / rt);
                }
            }
        }
        answer = stack.get(0);

        return answer;
    }

    public static void main(String[] args) {
        Answer M = new Answer();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println(M.solution(str));
    }

}
