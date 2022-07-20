package arraysandhashing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class GroupAnagrams49Test {

    @Test
    @DisplayName("문자열이 하나일 때 같은 문자열을 반환한다.")
    void 문자열이_하나인_아나그램() {
        GroupAnagrams49 sut = new GroupAnagrams49();
        String[] strs = new String[]{"a"};

        List<List<String>> expected = new ArrayList<>();
        List<String> empty = new ArrayList<>();
        empty.add("a");
        expected.add(empty);

        List<List<String>> result = sut.groupAnagrams(strs);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("빈 문자열일 때 빈문자열을 반환한다.")
    void 빈_문자열_아나그램() {
        GroupAnagrams49 sut = new GroupAnagrams49();
        String[] strs = new String[]{""};

        List<List<String>> expected = new ArrayList<>();
        List<String> empty = new ArrayList<>();
        empty.add("");
        expected.add(empty);

        List<List<String>> result = sut.groupAnagrams(strs);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("anagram group test")
    void 아나그램_그룹_로직_테스트() {
        GroupAnagrams49 sut = new GroupAnagrams49();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = getExpected();

        List<List<String>> result = sut.groupAnagrams(strs);
        Assertions.assertEquals(expected, result);
    }

    private List<List<String>> getExpected() {
        List<List<String>> expected = new ArrayList<>();

        List<String> first = new ArrayList<>();
        List<String> second = new ArrayList<>();
        List<String> third = new ArrayList<>();
        first.add("eat");
        first.add("tea");
        first.add("ate");

        second.add("bat");

        third.add("tan");
        third.add("nat");

        expected.add(first);
        expected.add(second);
        expected.add(third);
        return expected;
    }

}