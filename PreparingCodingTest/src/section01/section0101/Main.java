package section01.section0101;

import java.util.Scanner;

/**
 * input:
 * Computercooler
 * c
 *
 * ouput: 2
 */
class Main {
    public int solution(String str, char t) {
        int answer = 0;

        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        System.out.println("str = " + str + ", t = " + t);

//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == t) {
//                answer++;
//            }
//        }

        // for each
        for (char c : str.toCharArray()) {
            if (c == t) {
                answer ++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        String str = kb.next();
        char c = kb.next().charAt(0);

        System.out.print(T.solution(str, c));
    }
}
