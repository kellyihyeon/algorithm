package section01.section0104;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 3
 * good
 * Time
 * Big
 */
class Main {
    public ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        // 방법 1: StringBuilder() 사용
//        for (String x : str) {
//            String tmp = new StringBuilder(x).reverse().toString();
//            answer.add(tmp);
//        }

        // 방법 2:
        for (String x : str) {
            char[] s = x.toCharArray();
            int lt = 0;
            int rt = x.length() -1;
            while (lt < rt) {   // s t u d y
                char tmp = s[lt];   // s
                s[lt] = s[rt];   // y = y
                s[rt] = tmp;    // s = s
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = kb.next();
        }
        for (String x : T.solution(n, str)) {
            System.out.println(x);
        }
    }
}
