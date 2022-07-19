package arraysandhashing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TwoSum1Test {

    private TwoSum1 sut = new TwoSum1();

    @BeforeEach
    void setUp() {
        sut = new TwoSum1();
    }

    @Test
    @DisplayName("두 수를 합했을 때 target 의 수와 같아지는 숫자의 인덱스는 0과 1이다.")
    void two_sum_example3() {
        int[] nums = {3, 3};
        int target = 6;

        int[] answer = sut.twoSum(nums, target);
        Assertions.assertEquals(0, answer[0]);
        Assertions.assertEquals(1, answer[1]);
    }


    @Test
    @DisplayName("두 수를 합했을 때 target 의 수와 같아지는 숫자의 인덱스는 1과 2이다.")
    void two_sum_example2() {
        int[] nums = {3, 2, 4};
        int target = 6;

        int[] answer = sut.twoSum(nums, target);
        Assertions.assertEquals(1, answer[0]);
        Assertions.assertEquals(2, answer[1]);
    }

    @Test
    @DisplayName("두 수를 합했을 때 target 의 수와 같아지는 숫자의 인덱스는 0과 1이다.")
    void two_sum_example1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] answer = sut.twoSum(nums, target);
        Assertions.assertEquals(0, answer[0]);
        Assertions.assertEquals(1, answer[1]);
    }

}