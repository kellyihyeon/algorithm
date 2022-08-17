package arraysandhashing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductOfArrayExceptSelf238Test {

    @Test
    void nums에_0이_포함된_경우() {
        ProductOfArrayExceptSelf238 solution = new ProductOfArrayExceptSelf238();
        int[] answers = solution.productExceptSelf(new int[]{-1, 1, 0, -3,3});
        assertEquals(0, answers[0]);
        assertEquals(0, answers[1]);
        assertEquals(9, answers[2]);
        assertEquals(0, answers[3]);
        assertEquals(0, answers[4]);
    }

    @Test
    void sample() {
        ProductOfArrayExceptSelf238 solution = new ProductOfArrayExceptSelf238();
        int[] answers = solution.productExceptSelf(new int[]{1, 2, 3, 4});
        assertEquals(24, answers[0]);
        assertEquals(12, answers[1]);
        assertEquals(8, answers[2]);
        assertEquals(6, answers[3]);
    }

}