package com.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSorter {

    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        String[] strings2 = {"abce", "abcd", "cdx"};
        int n = 1;
        int n2 = 2;
        String[] answer = new StringSorter().useSortMethod(strings2, n2);
        for (String s : answer) {
            System.out.print(s + ", ");
        }

    }

    public String[] useSortMethod(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) ->
                {
                    if (s1.charAt(n) == s2.charAt(n)) {
                        return s1.compareTo(s2);
                    }
                    return s1.charAt(n) - s2.charAt(n);
                }
        );

        return strings;
    }

    public String[] solution(String[] strings, int n) {
        if (strings.length < 1) {
            return strings;
        }

        int pivotIndex = strings.length / 2;
        String pivot = strings[pivotIndex];
        List<String> left = new ArrayList<>();
        List<String> right = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            if (i == pivotIndex) {
                continue;
            }

            if (pivot.charAt(n) > strings[i].charAt(n)) {
                left.add(strings[i]);
            } else if (pivot.charAt(n) == strings[i].charAt(n)) {
                if (pivot.compareTo(strings[i]) > 0) {
                    left.add(strings[i]);
                } else {
                    right.add(strings[i]);
                }

            } else {
                right.add(strings[i]);
            }
        }

        List<String> box = new ArrayList<>();
        box.addAll(Arrays.asList(solution(left.toArray(new String[0]), n)));
        box.add(pivot);
        box.addAll(Arrays.asList(solution(right.toArray(new String[0]), n)));

        return box.toArray(new String[0]);
    }
}
