package section01.section0103;

import java.util.Scanner;

// it is time to study
class Main {
    public String solution(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE;

        // 방법 1
//        String[] s = str.split(" ");
//        for (String x : s) {
//            int len = x.length();
//            if (len > m) {
//                m = len;
//                answer = x;
//            }
//        }

        // 방법 2: indexOf(), substring() 사용
        int pos;
        while ((pos = str.indexOf(' ')) != -1){
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > m) {
                m = len;    // 2
                answer = tmp;   // it
            }
            str = str.substring(pos + 1);   // is time to study
        }
        if (str.length() > m) {
            answer = str;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        String str = kb.nextLine();
        System.out.print(T.solution(str));
    }
}
