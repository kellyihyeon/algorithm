package arraysandhashing;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 */
public class GroupAnagrams49 {


   public List<List<String>> groupAnagrams(String[] strs) {
       Map<String, List<String>> map = new HashMap<>();

       for (String anagram : strs) {
           char[] charsOfAnagram = anagram.toCharArray();
           Arrays.sort(charsOfAnagram);
           String sortedStr = new String(charsOfAnagram);

           if (map.containsKey(sortedStr)) {
               map.get(sortedStr).add(anagram);
           } else {
               List<String> values = new ArrayList<>();
               values.add(anagram);
               map.put(sortedStr, values);
           }
       }
       List<List<String>> answer = new ArrayList<>(map.values());

       return answer;
   }

}
