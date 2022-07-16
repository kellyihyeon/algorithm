package com.lab.studyplan.algorithm1.twopointers;


public class TwoSum167 {

    // by two pointers - 2ms
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

    // by binary search - 1ms
    public int[] twoSumByBinarySearch(int[] numbers, int target) {
        int[] answer = new int[2];

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                answer[0] = left + 1;
                answer[1] = right + 1;
                break;

            } else if (sum < target) {
                if (numbers[mid] + numbers[right] < target) {
                    left = mid + 1;
                } else {
                    left++;
                }
            } else {
                if (numbers[left] + numbers[mid] > target) {
                    right = mid - 1;
                } else {
                    right--;
                }

            }
        }//while

        return answer;
    }

    public static void main(String[] args) {
        final TwoSum167 T = new TwoSum167();
        int[] numbers = {2, 7, 11, 15};

        for (int i : T.twoSum(numbers, 9)) {
            System.out.print(i + " ");
        }
    }
}
