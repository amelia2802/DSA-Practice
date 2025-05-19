/*
 * Given an array of elements, return the length of the longest subarray where all its elements are distinct.
 * For example, given the array [5, 1, 3, 5, 2, 3, 4, 1],
 * return 5 as the longest subarray of distinct elements is [5, 2, 3, 4, 1].
 * 
 * @author Google
 * 
 * T.C:O(n)
 * S.C:O(n)
 * 
 * Topic:Sliding Window
 */

import java.util.*;
public class LongestSubArray {
    
    public static int longestSubArray(int[] arr) {
        int start = 0, end = 0, max = 0, n = arr.length;
        HashSet<Integer> set = new HashSet<>(); 
        while(end < n) {
            if(set.contains(arr[end])) {
                set.remove(arr[start++]);
            } else {
                set.add(arr[end++]);
                max = Math.max(max, end - start);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 5, 2, 3, 4, 1};
        System.out.println(longestSubArray(arr));
    }
}
