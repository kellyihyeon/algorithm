package arraysandhashing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicate217Test {

    ContainsDuplicate217 solution;

    @BeforeEach
    void setUp() {
        solution = new ContainsDuplicate217();
    }

    @Test
    @DisplayName("별개의 value 면 false 가 반환된다.")
    void 별개의_value() {
        boolean maybeFalse = solution.containsDuplicate(new int[]{1, 2, 3, 4});
        assertFalse(maybeFalse);
    }

    @ParameterizedTest
    @MethodSource("createArrays")
    @DisplayName("value 가 중복되면 true 가 반환된다.")
    void value가_최소_2개인_경우(int[] nums) {
        boolean maybeTrue = solution.containsDuplicate(nums);
        assertTrue(maybeTrue);
    }

    private static Stream<int[]> createArrays() {
        return Stream.of(
                new int[]{1, 2, 3, 1},
                new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2});
    }
}