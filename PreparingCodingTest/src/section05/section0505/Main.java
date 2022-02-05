package section05.section0505;

import java.util.Scanner;
import java.util.Stack;

/**
 * // 쇠막대기와 레이저의 배치를 나타내는 괄호가 문자열로 주어진다. (공백 없음, 최대 100,000)
 *         // () 이렇게 인접하게 여는 괄호, 닫는 괄호가 만나는 표시는 레이저이다. 쇠막대기의 길이는 (   ) 로 표시된다.
 *         // 괄호 한쌍이 인접하면 그 표시는 레이저, 인접하지 않으면 쇠막대기.
 *         // 쇠막대기에 레이저를 쐈을 때 막대기가 몇 개로 잘려지는지 출력하라.
 *
 *  ***  display = ()(((()())(())())) '(())' 이 부분을 누적된 레이저가 아니라 리셋된 레이저로 적용해야 하는데 못함.
 */
public class Main {

    // display = ()(((()())(())()))(())
    private int solution(String display) {
        int answer = 0;
        // stack [ ( -> 다음 ) 는 레이저가 아니라 쇠막대긴데 분별을 어떻게 할까?
        //                              -> laserIsOpen = true -> false 레이저가 나왔을 때 false 로 바꿔놓고
        // laser 가 존재한다고 해서 sum 을 laser + 1 하면, 레이저는 있는데 막대기가 없는 경우에는 해당되지 않으므로 막대기 개수를 곱해야 한다.
        Stack<Character> stack = new Stack<>();
        boolean laserIsOpen = false;
        int accumulatedLaser = 0;
        int laser = 0;
        int bar = 0;
        // (( ( () () ) ( () ) () ))
        // (( (       ) 레이저2 막대기1
        // 합계를 구한다.
        // (( (       ) (    ) 레이저1 막대기1
        // 합계를 구한다.
        // (( (       ) (    )    )
        // 합계를 구한다. (누적 레이저 사용)
        // (( (       ) (    )    ) )
        // 합계를 구한다. (누적 레이저 사용)
        // (( ( () () ) ( () ) () ))
        //              < 여기부터 레이저를 왜 3개로 안쓰고 1개로 썼는지 논리를 찾아야 한다.
        // 어떤 경우에 레이저의 총 개수를 이용하는지? 어떻게 막대기가 잘렸는지 이어졌는지를 판별할 것인지?
        // 레이저인지 막대기인지 구분은 변수 laserIsOpen 을 이용한다. (를 만나면 레이저를 열고, )를 만나면 닫는다.
        //    (( (       ) (    )    )) (  )
        //                              < 여기서는 누적 레이저가 아니라 리셋된 레이저로 가야되는데...

        for (char c : display.toCharArray()) {
            if (c == '(') {
                laserIsOpen = true;
                stack.push(c);
            } else { // ( c == ')')
                // ) 를 만나면 )가 1.레이저의 닫는 괄호면(open 돼있으면) pop 을 하고 2.막대기의 ) 면 오히려 스택에 push 한다.
                if (laserIsOpen) {  // 레이저인 경우
                    stack.pop();
                    if (stack.size() != 0) {
                        accumulatedLaser++;  // 4
                        laser++;            // 1
                        laserIsOpen = false;
                    }
                } else {    // open = false; -> 막대기인 경우
                    // 막대기의 )라면 한 과정을 더 추가한다. peek 해서 확인할 것. '('인지 ')'인지.
                    // ( 막대기면 )를 만나야 끝나는 막대기이므로 이 막대기의 길이만큼만 합계를 구한다.(누적된 레이저 x)
                    // ) 막대기면 막대가 앞에서부터 계속 이어지고 있는 막대기 이므로 전체 막대기의 길이만큼의 합계를 구한다.(누적된 레이저 o)
                    bar++;  // 막대기1
                    if (stack.peek() == '(') {
                        answer = answer + ((laser + 1) * bar);
                        laser = 0;
                    } else {    // ')' 면 이어지는 막대기
                        answer = answer + ((accumulatedLaser + 1) * bar);
                    }
                    bar = 0;
                    stack.push(c);
                }

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);

        String display = scanner.nextLine();
        System.out.println(M.solution(display));
    }
}
