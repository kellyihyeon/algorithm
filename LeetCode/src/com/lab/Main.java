package com.lab;

import com.lab.step01.TwoSum;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        final TwoSum solution = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        solution.twoSum(nums, target);
    }
}
