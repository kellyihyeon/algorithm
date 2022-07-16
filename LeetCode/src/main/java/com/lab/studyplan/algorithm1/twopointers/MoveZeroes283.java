package com.lab.studyplan.algorithm1.twopointers;

// 배열을 카피하지 않고 입력된 배열, nums 에서 다른 숫자의 순서는 유지하면서 0을 배열의 끝부분으로 보내기
// 투포인터
public class MoveZeroes283 {

    public void solution(int[] nums) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[right] == 0) {
                right++;
            } else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right++;
            }
        }
    }

    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 1;

        while (right != nums.length) {
            if (nums[left] == 0 && nums[right] != 0) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right++;
            } else if (nums[left] != 0 && nums[right] == 0) {
                right++;
                left++;
            } else if (nums[left] == 0 && nums[right] == 0) {
                right++;
            } else {
                left++;
                right++;
            }

        }

    }

    public static void main(String[] args) {
        final MoveZeroes283 M = new MoveZeroes283();
        int[] nums = {0, 1, 0, 3, 12};
        int[] nums2 = {0};
        int[] nums3 = {1, 34, 0, 2, 4, 0, 88, 0};

//        M.moveZeroes(nums3);
        M.solution(nums);
    }
}
