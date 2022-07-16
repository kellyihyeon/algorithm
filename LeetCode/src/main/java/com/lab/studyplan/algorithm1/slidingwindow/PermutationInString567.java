package com.lab.studyplan.algorithm1.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString567 {


    //Input: s1 = "ab", s2 = "eidbaooo"
    //Output: true
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> s2Map = new HashMap<>();

        int left = 0;
        int right = 0;

        while (right < s2.length()) {
            char leftChar = s2.charAt(left);
            char rightChar = s2.charAt(right);

            s2Map.put(rightChar, s2Map.getOrDefault(rightChar, 0) + 1);

            int length = right - left + 1;
            if (length == s1.length()) {
                if (s1Map.equals(s2Map)) {
                    return true;    // character 와 갯수가 맞으면 바로 true 반환.
                } else {
                    int tmp = s2Map.get(leftChar);
                    if (tmp == 1) {
                        s2Map.remove(leftChar);
                    } else {
                        s2Map.put(leftChar, tmp - 1);
                    }
                    left++;
                }
            }
            right++;
        }

        return false;

    }
}
