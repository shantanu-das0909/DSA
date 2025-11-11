package SlidingWindow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MaxInSubArray {

    public int[] solve(int[] arr, int k) {
        int i = 0, j = 0, n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[n-k+1];

        while(j < n) {
            while(!q.isEmpty() && arr[q.peek()] < arr[j]) {
                q.poll();
            }
            q.add(j);

            if(j - i + 1 == k) {
                result[i] = arr[q.peek()];
                i++;
                if(i-1 == q.peek()) {
                    q.poll();
                }
            }

            j++;
        }

        return result;
    }
    static void main(String[] args) {
        int[] arr = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(new MaxInSubArray().solve(arr, k)));
    }

}
