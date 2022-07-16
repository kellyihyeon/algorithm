package com.lab.studyplan.algorithm1.twopointers;

// You must do this by modifying the input array in-place with O(1) extra memory.
public class ReverseString344 {

    // Input: s = ["h","e","l","l","o"]
    // Output: ["o","l","l","e","h"]

    // 1ms
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        // l과 r을 각각 0, s.length-1 자리에 두고 서로 위치를 바꾼다.
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }



    public static void main(String[] args) {
        final ReverseString344 R = new ReverseString344();
        char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};
        char[] s2 = {'h', 'e', 'l', 'l', 'o'};
        R.reverseString(s2);
    }
}
