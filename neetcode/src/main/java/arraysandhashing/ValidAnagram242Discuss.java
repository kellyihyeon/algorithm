package arraysandhashing;

import java.util.Arrays;

public class ValidAnagram242Discuss {


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] chS = s.toCharArray();
        char[] chT = t.toCharArray();

        Arrays.sort(chS);
        Arrays.sort(chT);

        return Arrays.equals(chS, chT);
    }
}
