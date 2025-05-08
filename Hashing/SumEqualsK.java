/*
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * Bonus: Can you do this in one pass?
 * 
 * @author Google
 * 
 * T.C:1st app: O(n²), 2nd app:O(n) 
 * S.C:1st app: O(1), 2nd app:O(n) 
 * 
 * ```Topic:Hashing```
 */
import java.util.*;
public class SumEqualsK {
    public static boolean checkSum(int arr[],int k){
        for(int i=0;i<arr.length;i++){
            int j = i+1;
            while(j<arr.length){
                int sum = arr[i] + arr[j];
                if(sum==k){
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    public static boolean bonusCheck(int arr[],int k){
        HashSet<Integer> tempSet = new HashSet<>();

        for(int i=0;i<arr.length;i++){
            int checkNum = k - arr[i];

            if(tempSet.contains(checkNum)){
                return true;
            }
            tempSet.add(arr[i]);
        }
        return false;
    }
    public static void main(String[] args) {
     int numList[] = {10,15,3,7};
     int k = 17;

     int numList1[] = {1,-2,1,0,5};
     int k2 = 0;
     
     //Check All Pairs: Two Pointer
     System.out.println(checkSum(numList,k));
     System.out.println(checkSum(numList1,k2));

     //Check By Hashing
     System.out.println(bonusCheck(numList, k));
     System.out.println(bonusCheck(numList1,k2));
    }
}
