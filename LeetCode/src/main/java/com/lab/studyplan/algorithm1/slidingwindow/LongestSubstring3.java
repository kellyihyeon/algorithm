package com.lab.studyplan.algorithm1.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring3 {

    //Input: s = "a b c a b c b b"
    //Output: 3
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;

        Set<Character> set = new HashSet<>();

        if (s.length() == 0) {
            return 0;
        }

        while (right < s.length()) {
            char ch = s.charAt(right);

            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(ch);
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
