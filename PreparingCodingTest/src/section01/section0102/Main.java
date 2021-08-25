package section01.section0102;

import java.util.Scanner;


class Main {
    public String solution(String str) {
        String answer = "";
        for (char x : str.toCharArray()) {
            if (Character.isLowerCase(x)) {
                answer += Character.toUpperCase(x);
            } else {
                answer += Character.toLowerCase(x);
            }
        }

        // 아스키코드 활용
        for (char x : str.toCharArray()) {
            if (x >= 65 && x <= 90) {   // 대문자
                answer += Character.toLowerCase(x);
            } else {
                answer += Character.toUpperCase(x);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        String str = kb.next();
        System.out.print(T.solution(str));
    }
}
