package com.algorithm.sort;

import java.util.Arrays;

public class HIndex {

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};

        int answer = new HIndex().solution(citations);
        System.out.println("answer = " + answer);
    }

    public int solution(int[] citations) {
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
    }

}
