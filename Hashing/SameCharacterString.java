/*
    Given a string s, return true if it contains the same number of verbal characters and non-verbal characters.
    Return false otherwise.

    Verbal characters:

    a, e, i, o, u (both uppercase + lowercase)

    Non-verbal characters:

    Every alphabet that is not a vowel. (Ignore digits, spaces, and symbols entirely.)

    Example
    Input: "HeLLo!"
    Verbal: e, o → 2
    Non-verbal: H, L, L → 3
    Output: false

    Input: "AiOuD"
    Verbal: A, i, O, u → 4
    Non-verbal: D → 1
    Output: false

    Input: "BaNaNa"
    Verbal: a, a, a → 3
    Non-verbal: B, N, N → 3
    Output: true

    Rules

    Don't convert entire string to lower/upper — if you decide to convert, justify it.

    No extra arrays. Counting only.

    Your solution must use a mapping mindset:

    Identify character → categorize → count.

    Focus on clean logic, not optimization.
*/

import java.util.*;

public class SameCharacterString {
    public static boolean isValid(String s) {
        HashSet<Character> vowelSet = new HashSet<>();
        int vowelCount = 0;
        int consCount = 0;

        Collections.addAll(vowelSet,'a', 'e', 'i', 'o','u','A', 'E', 'I', 'O','U');

        for(int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))){
                if(vowelSet.contains(s.charAt(i))){
                    vowelCount++;
                }
                else{
                    consCount++;
                }
            }
        }

        return (vowelCount==consCount);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isValid(s));
        sc.close();
    }
}
