package SlidingWindow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNumber {

    int[] solve(int[] numbers, int k){
        int i = 0, j = 0, n = numbers.length;
        Queue<Integer> trackNegative = new LinkedList<>();
        int[] result = new int[n - k + 1];

        while(j < n) {
            if(numbers[j] < 0) {
                trackNegative.add(j);
            }
            if (j - i + 1 == k) {
                result[i] = !trackNegative.isEmpty() ? numbers[trackNegative.peek()] : 0;
                i++;
            }
            if(!trackNegative.isEmpty() && trackNegative.peek() < i) {
                trackNegative.poll();
            }
            j++;
        }

        return result;
    }

    // first negative number in every window of size k
    static void main(String[] args) {
        int[] numbers = new int[]{22, 90, 12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;

        System.out.println(Arrays.toString(new FirstNegativeNumber().solve(numbers, k)));
    }
}
