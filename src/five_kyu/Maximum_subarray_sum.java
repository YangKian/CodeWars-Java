package five_kyu;

/**
 * Description:
 * The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or list
 * of integers:
 *
 * Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
 * // should be 6: {4, -1, 2, 1}
 * Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array.
 * If the list is made up of only negative numbers, return 0 instead.
 *
 * Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray.
 */
public class Maximum_subarray_sum {
    //解法一：
    public static int sequence(int[] arr) {
        final int size = arr.length;
        if(size == 0) return 0;
        int[] temp = new int[size];
        temp[0] = arr[0];
        int max = 0;
        for(int i = 1; i < size; ++i) {
            temp[i] = temp[i - 1] >= 0 ? arr[i] + temp[i - 1] : arr[i];
            if(temp[i] > max) {
                max = temp[i];
            }
        }
        return max;
    }

    //解法二：空间复杂度O(n)
    public static int sequence1(int[] arr) {
        final int size = arr.length;
        if(size == 0) return 0;

        int ans = arr[0];
        int sum = arr[0];
        for(int i = 1; i < size; ++i) {
            sum = sum + arr[i] > arr[i] ? sum + arr[i] : arr[i];
            if(sum > ans) ans = sum;
        }
        if(ans < 0) ans = 0;
        return ans;
    }
}
