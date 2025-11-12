package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKUniqueChars {

    int solve(String ss, int k) {
        int maxL = -1, i = 0, j = 0;
        char[] s = ss.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        while(j < s.length) {
            if(map.size() < k) {
                map.put(s[j], map.getOrDefault(s[j], 0) + 1);
            }
            else if(map.size() == k) {
                maxL = Math.max(maxL, j - i + 1);
                if(map.containsKey(s[j])) {
                    map.put(s[j], map.get(s[j]) + 1);
                } else {
                    while(map.size() == 3) {
                        map.put(s[i], map.get(s[i]) - 1);
                        map.remove(s[i], 0);
                        i++;
                    }
                    map.put(s[j], 1);
                }
            }

            j++;
        }


        return maxL;
    }
    static void main(String[] args) {
        String s = "ababcbebebe";
        int k = 3;
        System.out.println(new LongestSubStringWithKUniqueChars().solve(s, k));
    }
}
