package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A = 65, a = 97
 * B = 66, b = 98
 * 차이 = 32
 */
public class String02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final char[] chars = br.readLine().toCharArray();
        int gap = 32;
        StringBuilder result = new StringBuilder();

        // 1. S = 정수로 변환한다. 예: 68
        // 2. 68 + 32 = 정수. 정수를 아스키코드로 변환한다.
        for (char character : chars) {    // S t u D Y
            if (character < 97) {   // 대문자
                result.append((char) (character + gap));
            } else {
                result.append((char) (character - gap));
            }
        }
        System.out.println(result);

    }
}
