package SlidingWindow;

// Maximum sum subarray of size k

import java.util.HashMap;
import java.util.Map;

public class MaxSum {
    public int solve(int[] nums, int k) {
        int i = 0, prefixSum = 0, maxL = 0;
        Map<Integer, Integer> indexMap = new HashMap<>();

        // if prefixSum == k, at index i.that means we found our match & the maxL will be i + 1
        // if map contains (prefixSum - k) then we found another match i.e. i - map(prefixSum - k)
        while (i < nums.length) {
            prefixSum += nums[i];
            if(prefixSum == k) {
                maxL = i + 1;
            } else if (indexMap.containsKey(prefixSum - k)) {
                maxL = Math.max(maxL, i - indexMap.get(prefixSum - k));
            }

            if(!indexMap.containsKey(prefixSum)) {
                indexMap.put(prefixSum, i);
            }
            i++;
        }

        return maxL;
    }

    static void main(String[] args) {
        int[] nums = new int[]{10, 5, 2, 7, 1, -10};
        int k = 15;

        System.out.println(new MaxSum().solve(nums, k));
    }
}
