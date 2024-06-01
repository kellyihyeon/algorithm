package com.algorithm.graphandnonlinearsearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Word {
    String name;
    int depth;

    public Word(String name, int depth) {
        this.name = name;
        this.depth = depth;
    }
}

public class WordConversion {

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};

        int answer = new WordConversion().solution(begin, target, words);
        System.out.println("answer = " + answer);
    }

    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        Stack<Word> stack = new Stack<>();
        stack.push(new Word(begin, 0));

        Set<String> wordSets = new HashSet<>();

        while (!stack.isEmpty()) {
            Word word = stack.pop();

            if (word.name.equals(target)) {
                return word.depth;
            }

            for (String wordToCheck : words) {
                if (wordSets.contains(wordToCheck)) {
                    continue;
                }

                if (isConvert(wordToCheck, word)) {
                    stack.push(new Word(wordToCheck, word.depth + 1));
                    wordSets.add(wordToCheck);
                }
            }
        }

        return 0;
    }

    private boolean isConvert(String wordToCheck, Word word) {
        int count = 0;

        for (int i = 0; i < word.name.length() && count < 2; i++) {
            if (word.name.charAt(i) != wordToCheck.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }
}
