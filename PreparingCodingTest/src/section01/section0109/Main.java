package section01.section0109;

import java.util.Scanner;

/**
 * 아스키 코드 0 ~ 9 = 48 ~ 57
  */
class Main {
    public int solution(String str) {
        int answer = 0;
        for (char x : str.toCharArray()) {
            if (x >= 48 && x <= 57) {   // 4 0 1 3 -> 52 48 49 51
                // 4, 40, 401, 4013
                answer = answer * 10 + (x - 48);
            }
        }
        return answer;
    }

    public int solution2(String str) {
        String answer = "";
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                answer += x;
            }
        }
        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        String str = kb.next();
        System.out.print(T.solution(str));
    }
}
