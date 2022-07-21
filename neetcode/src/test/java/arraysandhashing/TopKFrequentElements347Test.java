package arraysandhashing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentElements347Test {

    TopKFrequentElements347 sut;

    @BeforeEach
    void setUp() {
        sut = new TopKFrequentElements347();
    }


    @Test
    void testCase3() {
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int k = 2;

        int[] answers = sut.topKFrequent(nums, k);
        assertEquals(-1, answers[0]);
        assertEquals(2, answers[1]);
    }

    @Test
    void testCase2() {
        int[] nums = {1};
        int k = 1;

        int[] answers = sut.topKFrequent(nums, k);
        assertEquals(1, answers[0]);
    }

    @Test
    void testCase1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] answers = sut.topKFrequent(nums, k);
        assertEquals(1, answers[0]);
        assertEquals(2, answers[1]);
    }

}