package SlidingWindow;

public class MaxSum {
    public int solve(int[] nums, int k) {
        int i = 0, j = 0, sum = 0, maxSum = Integer.MIN_VALUE;

        while(j < nums.length) {
            sum += nums[j];
            if(j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum -= nums[i];
                i++;
                j++;
            }
        }

        return maxSum;
    }

    static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;

        System.out.println(new MaxSum().solve(nums, k));
    }
}
