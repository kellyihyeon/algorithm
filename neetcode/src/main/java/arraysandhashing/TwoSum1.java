package arraysandhashing;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
public class TwoSum1 {

    public int[] twoSum(int[] nums, int target) {
        int[] answers = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    answers[0] = i;
                    answers[1] = j;
                    return answers;
                }
            }
        }

        return answers;
    }

}
