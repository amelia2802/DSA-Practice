/*
 * Given a string, determine whether any permutation of it is a palindrome.
 * For example, carrace should return true, since it can be rearranged to form racecar, which is a palindrome. 
 * daily should return false, since there's no rearrangement that can form a palindrome.
 * 
 * @author Amazon
 * 
 * T.C:O(n)
 * S.C:O(1)
 * 
 * Topic:String Manipulation,Hashing
 */
import java.util.*;


public class PermutationPalindrome {
    public static boolean canFormPalindrome(String str) {
        // Use a HashMap to count character frequencies
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Count characters with odd frequencies
        int oddCount = 0;
        for (int count : charCount.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
            if (oddCount > 1) {
                return false; // More than one odd frequency means no palindrome
            }
        }

        return true; // Can form a palindrome
    }

    public static void main(String[] args) {
        String input = "carrace";
        System.out.println("Can form palindrome? " + canFormPalindrome(input)); // true

        input = "daily";
        System.out.println("Can form palindrome? " + canFormPalindrome(input)); // false
    }
}