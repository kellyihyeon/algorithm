package com.lab.studyplan.algorithm1.twopointers;

import java.util.Arrays;

public class SquaresOfaSortedArray977 {

    public int[] sortedSquaresUsingTwoPointers(int[] nums) {
        int[] answer = new int[nums.length];

        int left = 0;
        int right = answer.length - 1;
        int index = answer.length - 1;

        while (left <= right) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                answer[index--] = nums[right] * nums[right];
                right--;
            } else {
                answer[index--] = nums[left] * nums[left];
                left++;
            }
        }

        return answer;
    }


    public int[] sortedSquares(int[] nums) {
        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            answer[i] = (int) Math.pow(nums[i], 2);
        }

        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        final SquaresOfaSortedArray977 S = new SquaresOfaSortedArray977();
//        int[] nums = {-4, -1, 0, 3, 10};
        int[] nums = {-7,-3,2,3,11};

        for (int i : S.sortedSquaresUsingTwoPointers(nums)) {
            System.out.print(i + " ");
        }
    }
}
