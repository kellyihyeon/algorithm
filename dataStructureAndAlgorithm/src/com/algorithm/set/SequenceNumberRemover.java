package com.algorithm.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SequenceNumberRemover {

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        int[] arr2 = {4, 4, 4, 3, 3};

        int[] answers = new SequenceNumberRemover().solution(arr2);
        System.out.println("answers = " + Arrays.toString(answers));

    }

    public int[] applySetPrinciple(int[] arr) {
        List<Integer> tmp = new LinkedList<>();
        int last = -1;

        for (int num : arr) {
            if (last == num) {
                continue;
            }

            last = num;
            tmp.add(num);
        }

        return tmp.stream().mapToInt(Integer::intValue).toArray();
    }


    public int[] solution(int[] arr) {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int previous = arr[i - 1];
            int current = arr[i];

            if (previous != current) {
                tmp.add(current);
            }
        }

        return tmp.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }
}
