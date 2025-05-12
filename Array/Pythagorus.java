/*
 * Given an array of integers, determine whether it contains a Pythagorean triplet.
 * Recall that a Pythogorean triplet (a, b, c) is defined by the equation 
 * a2+ b2= c2
 * 
 * @author Netflix
 * 
 * T.C:O(n^2)
 * S.C:O(1)
 * 
 * Topics:Two-Pointer Technique
 */

import java.util.Arrays;

class Pythagorus{
    public static boolean isPythagorean(int[] arr){
        for(int i=arr.length-1;i>=0;i--){
            int l = 0;
            int r = i-1;

            while(l<r){
                if(arr[l]+arr[r]==arr[i]){
                    return true;
                }
                if(arr[l]+arr[r]<arr[i]){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int array[] = {3, 1, 4, 6, 5};
        int array2[] = {10, 4, 6, 12, 5};

        for(int i=0;i<array.length;i++){
            array[i] = array[i] * array[i];
        }

        Arrays.sort(array);
        System.out.println(isPythagorean(array));
        System.out.println(isPythagorean(array2));
        
    }
}