package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String rawString = br.readLine().toLowerCase();
        final char[] chars = rawString.toCharArray();
        final char character = br.readLine().toLowerCase().charAt(0);

        int count = 0;

        for (char c : chars){   // t o m a t o
            if (c == character) {
                count++;
            }
        }
        System.out.println(count);
    }

}
