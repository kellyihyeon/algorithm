package com.lab.studyplan.algorithm1.twopointers;

//Input: s = "Let's take LeetCode contest"
//Output: "s'teL ekat edoCteeL tsetnoc"
public class ReverseWords557 {


    // 8ms
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();

        String[] wordComponents = s.split(" ");

        for (String word : wordComponents) {
            builder.append(reverse(word)).append(" ");
        }

        return builder.deleteCharAt(builder.length() - 1).toString();
    }


    private String reverse(String word) {
        char[] seperatedStr = word.toCharArray();
        int left = 0;
        int right = seperatedStr.length - 1;

        while (left < right) {
            char tmp = seperatedStr[left];
            seperatedStr[left] = seperatedStr[right];
            seperatedStr[right] = tmp;
            left++;
            right--;
        }

        return String.valueOf(seperatedStr);
    }


    public static void main(String[] args) {
        final ReverseWords557 R = new ReverseWords557();
        final String s = R.reverseWords("Let's take LeetCode contest");
        System.out.println(s);
    }
}
