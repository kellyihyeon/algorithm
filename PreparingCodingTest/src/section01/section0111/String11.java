package section01.section0111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class String11 {
    public static List<String> solution(String str) {
        List<String> answer = new ArrayList<>();
        int count = 1;
        String target;

        // answer = K, 2, H, S
        for (int i = 0; i < str.length(); i++) {   // str = K K H S S S 'S S S S E
            target = String.valueOf(str.toCharArray()[i]); // K K H S S S S
            if (answer.contains(target)) {
                count++;
                if (str.toCharArray()[i] != str.toCharArray()[i + 1]) { // ArrayIndexOutOfBoundsException
                    answer.add(String.valueOf(count));
                    count = 1;
                }
            } else {
                answer.add(target);
            }
        }
        return answer;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String str = br.readLine();

        for (String s : solution(str)) {
            System.out.print(s);
        }
    }
}
