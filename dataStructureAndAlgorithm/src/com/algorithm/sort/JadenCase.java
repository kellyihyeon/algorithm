package com.algorithm.sort;

public class JadenCase {

    public static void main(String[] args) {
        String sentence = "3people unFollowed me";
        String sentence2 = "for the last week";

        String answer = new JadenCase().solution(sentence);
        System.out.println("answer = " + answer);
    }


    public String solution(String s) {
        StringBuilder builder = new StringBuilder();
        s = s.toLowerCase();
        char lastLetter = ' ';

        for (char c : s.toCharArray()) {
            if (lastLetter == ' ') {
                c = Character.toUpperCase(c);
            }
            builder.append(c);
            lastLetter = c;
        }

        return builder.toString();
    }


    // TODO. 왜 실패했는지 모르겠음
    public String failCase(String s) {
        StringBuilder builder = new StringBuilder();
        String[] words = s.split(" ");

        for (String word : words) {
            String lowerCase = word.toLowerCase();

            if (!lowerCase.isEmpty()) {
                if (!Character.isDigit(lowerCase.charAt(0))) {
                    char firstLetter = Character.toUpperCase(lowerCase.charAt(0));
                    String lastLetter = lowerCase.substring(1);
                    word = firstLetter + lastLetter;

                }
                builder.append(word).append(" ");
            }
        }

        return builder.toString().stripTrailing();
    }
}
