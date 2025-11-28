/*
    Almost Balanced String”
    Problem Statement

    You are given a string s containing only lowercase letters.

    A string is called balanced if:

    The number of vowels equals the number of consonants.

    You are allowed to remove at most ONE character from the string.

    Task

    Return true if the string can be made balanced by removing at most one character.
    Otherwise, return false.

    🔍 Examples
    Example 1
    Input: "apple"


    Vowels = 2 (a, e)
    Consonants = 3 (p, p, l)
    Remove 'l' → now vowels = consonants
    ✅ Output: true

    Example 2
    Input: "abc"


    a = vowel
    b, c = consonants
    Remove any one → still unbalanced
    ❌ Output: false

    Example 3
    Input: "aeiob"


    Vowels = 4
    Consonants = 1
    Remove one vowel → still unbalanced
    ❌ Output: false

    Example 4
    Input: "ab"


    Already balanced
    ✅ Output: true

    ✅ Constraints

    1 ≤ s.length ≤ 10⁵

    Only lowercase letters
*/
import java.util.*;

public class AlmostBalancedString {
    public static boolean isAlmostBalanced(String s){
        /**
         * 
         * Return true IF the difference between the count of vowel and consonant id <=1
         */

        int vowelCount = 0;
        int consonantCount = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isLetter(ch)){
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                    vowelCount++;
                }
                else{
                    consonantCount++;
                }
            }
        }
        if (vowelCount == consonantCount){
            return true;  // Already balanced
        }
        else if (vowelCount > consonantCount && vowelCount - 1 == consonantCount){
            return true;  // Remove 1 vowel
        }
        else if (vowelCount < consonantCount && vowelCount == consonantCount - 1){
            return true;  // Remove 1 consonant
        }
        return false;
        
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String s = sc.nextLine();
        System.out.println(isAlmostBalanced(s));
        sc.close();
    }    
}
