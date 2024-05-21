package com.algorithm.linearsearch;

public class StringCounter {

    public static void main(String[] args) {
        String s = "pPoooyY";
        String s2 = "Pyy";
        boolean answer = new StringCounter().useRegularExpression(s);
        System.out.println("answer = " + answer);
    }

    boolean useRegularExpression(String s) {
        int p = s.replaceAll("[^pP]", "").length();
        int y = s.replaceAll("[^yY]", "").length();

        return p == y;
    }


    boolean solution(String s) {
        int count = 0;
        char[] chars = s.toUpperCase().toCharArray();

        for (char character : chars) {
            if (character == 'P') {
                count++;
            }

            if (character == 'Y') {
                count--;
            }
        }

        return count == 0;
    }
}
