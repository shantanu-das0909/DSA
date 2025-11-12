package SlidingWindow;

public class LargestSubarrayOfSumK {

    int solve(int[] arr, int k) {
        int n = arr.length, i = 0, j = 0, sum = 0, maxL = 0;
        while(i < n && j < n) {
            sum = sum + arr[j];

            if(sum == k) {
                maxL = Math.max(maxL, j - i + 1);
                sum = sum - arr[i];
                i++;
            }
            else if(sum > k) {
                sum = sum - arr[i];
                j--;
            }
            j++;
        }
        return maxL;
    }

    static void main(String[] args) {
        int[] arr = new int[]{10, 5, 2, 7, 1, -10};
        int k = 15;
        System.out.println(new LargestSubarrayOfSumK().solve(arr, k));
    }
}
