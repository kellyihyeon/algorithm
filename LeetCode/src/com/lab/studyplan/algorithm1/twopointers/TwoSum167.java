package com.lab.studyplan.algorithm1.twopointers;

// 2ms
public class TwoSum167 {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        final TwoSum167 T = new TwoSum167();
        int[] numbers = {2, 7, 11, 15};

        for (int i : T.twoSum(numbers, 9)) {
            System.out.print(i + " ");
        }
    }
}
