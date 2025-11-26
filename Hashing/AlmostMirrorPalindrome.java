/*
    Almost Mirror Palindrome

    **Given a string `s`, check if it becomes a *mirror palindrome* after removing at most *one* character.**

    Mirror palindrome rules:

    * It should read the same forward/backward
    * It should contain only mirror characters (A, H, I, M, O, T, U, V, W, X, Y, 0, 1, 8)
    * Ignore non-alphanumeric characters
    * Case-insensitive
    * You are allowed to remove **one** character to try to fix it

    ### Example 1

    **Input:** `"AAXO"`

    * Cleaned → "AAXO"
    * Remove 'X' → "AAO" → Not mirror
    * Remove 'O' → "AAX" → Not mirror
    → Output: **false**

    ### Example 2

    **Input:** `"A8@8A"`

    * Cleaned → "A8 8A" → "A88A"
    * Already mirror → **true**

    ### Example 3

    **Input:** `"WXM@XW"`

    * Cleaned → "WXM XW" → "WXMXW"
    * Not mirror.
    * Remove middle "M" → "WXXW" → mirror.
    → Output: **true**

    ---

    # 🔥 What I want from you

    Before coding, tell me:

    ### **1. Your approach in steps — short and clear**

    Try to think:

    * where two-pointer comes in
    * where mirror-set check happens
    * when removal is tried

    ### **2. Your expected time complexity**

    ### **3. Any edge cases you think matter**

    I’ll critique your logic before you code.


*/

import java.util.Set;

public class AlmostMirrorPalindrome {
        /*
            1. Clean the string (spaces+ remove non-alphanumeric)  and convert it into uppercase
create a character set with mirror characters

            2. Use two pointers: i = 0, j = n-1

            3. While i < j:
            - If s[i] == s[j] and both containg the set: move both pointers inward 
            
            - If s[i] != s[j]: NOW YOU HAVE A MISMATCH
                → Try skipping s[i]: check if substring (i+1, j) is palindrome and contains the set 
                → Try skipping s[j]: check if substring (i, j-1) is palindrome and contains the set 
                → If EITHER works, return true
                → If NEITHER works, return false

            4. If loop completes without issues, return true (already mirror palindrome) 
        */
       public static boolean isAlmostMirrorPalindrome(String s) {
        // Step 1: Clean the string (alphanumeric only, uppercase)
        StringBuilder cleaned = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toUpperCase(c));
            }
        }
        
        String str = cleaned.toString();
        
        // Step 2: Define mirror character set
        Set<Character> mirrorSet = Set.of('A', 'H', 'I', 'M', 'O', 'T', 'U', 'V', 'W', 'X', 'Y', '0', '1', '8');
        
        // Step 3: Check if ALL characters are in the mirror set
        for (char c : str.toCharArray()) {
            if (!mirrorSet.contains(c)) {
                return false; // Can't fix non-mirror chars by removal
            }
        }
        
        // Step 4: Check if it's a palindrome with at most 1 removal
        return isPalindromeWithOneRemoval(str);
    }
    
    private static boolean isPalindromeWithOneRemoval(String s) {
        int i = 0, j = s.length() - 1;
        
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                // Mismatch found - try removing either character
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }
        
        return true; // Already a palindrome
    }
    
    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    // Test cases
    public static void main(String[] args) {
        System.out.println(isAlmostMirrorPalindrome("AAXO"));        // false
        System.out.println(isAlmostMirrorPalindrome("A8@8A"));      // true
        System.out.println(isAlmostMirrorPalindrome("WXM@XW"));     // true
        System.out.println(isAlmostMirrorPalindrome("AHA"));        // true
        System.out.println(isAlmostMirrorPalindrome("ABBA"));       // false (B not mirror)
        System.out.println(isAlmostMirrorPalindrome(""));           // true (empty)
        System.out.println(isAlmostMirrorPalindrome("A"));          // true (single)
        System.out.println(isAlmostMirrorPalindrome("BBB"));        // false (no mirror chars)
    }
}
