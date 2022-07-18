package arraysandhashing;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */
public class ValidAnagram242 {


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        List<Character> sList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            sList.add(c);
        }

        List<Character> tList = new ArrayList<>();
        for (char c : t.toCharArray()) {
            tList.add(c);
        }

        while (sList.size() != 0) {
            Character tmp = tList.get(0);
            if (sList.contains(tmp)) {
                sList.remove(tmp);
                tList.remove(tmp);
            } else {
                return false;
            }
        }

        return true;
    }
}
