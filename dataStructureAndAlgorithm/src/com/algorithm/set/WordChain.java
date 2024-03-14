package com.algorithm.set;

import java.util.HashSet;
import java.util.Set;

public class WordChain {

    public static void main(String[] args) {
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "knee"};
        String[] words2 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        boolean answer = new WordChain().solution(words);
        System.out.println("answer = " + answer);
    }

    public boolean compact(String[] words) {
        Set<String> checker = new HashSet<>();
        checker.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            char last = words[i - 1].charAt(words[i - 1].length() - 1);
            char first = words[i].charAt(0);

            if (last != first) {
                return false;
            }

            if (!checker.add(words[i])) {
                return false;
            }
        }

        return true;
    }

    public boolean solution(String[] words) {
        boolean answer = true;

        Set<String> checker = new HashSet<>();
        checker.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            char[] previousChars = words[i - 1].toCharArray();

            char last = previousChars[previousChars.length - 1];
            char first = chars[0];

            if (!String.valueOf(last).equals(String.valueOf(first))) {
                return false;
            }

            if (checker.contains(words[i])) {
                return false;
            }

            checker.add(words[i]);
        }

        return answer;
    }
}
