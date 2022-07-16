package com.lab.studyplan.algorithm1.binarysearch;

//You must write an algorithm with O(log n) runtime complexity.
public class SearchInsertPosition35 {


    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        final SearchInsertPosition35 S = new SearchInsertPosition35();

        int[] nums = {1, 3, 5, 6};
        int target = 7;

        System.out.println(S.searchInsert(nums, target));
    }
}
