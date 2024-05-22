package com.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallestNumberRemover {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        int[] arr2 = {10};
        int[] arr3 = {};
        int[] arr4 = {24, 3, 2, 31, 8, 33, 94};

        int[] answers = new SmallestNumberRemover().useLambdaExpression(arr4);

        for (int answer : answers) {
            System.out.print(answer + " ");
        }
    }

    public int[] useLambdaExpression(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int min = Arrays.stream(arr).min().getAsInt();

        return Arrays.stream(arr).filter(value -> value != min).toArray();
    }

    public int[] solution2(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            if (min > i) {
                min = i;
            }
        }

        int[] answer = new int[arr.length - 1];
        int index = 0;

        for (int number : arr) {
            if (number != min) {
                answer[index++] = number;
            }
        }

        return answer;
    }

    public int[] solution(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return new int[]{-1};
        }

        int min = arr[0];
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                index = i;
            }
        }

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                answer.add(arr[i]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
