package SlidingWindow;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class CountAnagrams {

    public int countAnagram(String s, String pattern) {
        Map<Character, Long> map = pattern.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(
                c -> c, Collectors.counting()
        ));

        int i = 0, j = 0, n = s.length(), k = pattern.length(), count =  map.size(), numberOfAnagrams = 0;

        while(j < n) {
            if(map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if(map.get(s.charAt(j)) == 0) count--;
            }
            if (j - i + 1 == k) {
                if(count == 0) {
                    numberOfAnagrams++;
                }
                if(map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                    if(map.get(s.charAt(i)) > 0) count++;
                }
                i++;
            }
            j++;
        }


        return numberOfAnagrams;
    }
    public static void main(String[] args) {
        String s = "aabaabaa";
        String pattern = "aaba";

        System.out.println(new CountAnagrams().countAnagram(s, pattern));
    }
}
