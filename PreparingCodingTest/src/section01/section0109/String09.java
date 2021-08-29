package section01.section0109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String09 {
    public static int solution(String str) {
        String answer = "";

        char[] toCharArray = str.toCharArray();
        for (char c : toCharArray) {
            if (Character.isDigit(c)) {
                answer += c;
            }
        }
        return Integer.parseInt(answer);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String str = br.readLine();

        System.out.println(solution(str));
    }
}
