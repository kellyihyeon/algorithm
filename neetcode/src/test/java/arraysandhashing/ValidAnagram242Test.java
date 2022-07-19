package arraysandhashing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidAnagram242Test {

    ValidAnagram242 sut;
    ValidAnagram242Discuss discuss;

    @BeforeEach
    void setUp() {
        sut = new ValidAnagram242();
        discuss = new ValidAnagram242Discuss();
    }

    @Test
    @DisplayName("s와 t의 길이가 같지 않은 경우 false 가 반환된다.")
    void 길이가_같지_않은_경우() {
        String s = "ab", t = "a";
        boolean maybeFalse = sut.isAnagram(s, t);
        boolean maybeFalse2 = discuss.isAnagram(s, t);

        assertFalse(maybeFalse);
        assertFalse(maybeFalse2);
    }

    @Test
    @DisplayName("t가 s의 아나그램이 아니면 false 가 반환된다.")
    void 아나그램이_아닌_경우() {
        String s = "rat", t = "car";
        boolean maybeFalse = sut.isAnagram(s, t);
        boolean maybeFalse2 = discuss.isAnagram(s, t);

        assertFalse(maybeFalse);
        assertFalse(maybeFalse2);
    }

    @Test
    @DisplayName("t가 s의 아나그램이면 true 가 반환된다.")
    void 아나그램인_경우() {
        String s = "anagram", t = "nagaram";
        boolean maybeTrue = sut.isAnagram(s, t);
        boolean maybeTrue2 = discuss.isAnagram(s, t);

        assertTrue(maybeTrue);
        assertTrue(maybeTrue2);
    }

}