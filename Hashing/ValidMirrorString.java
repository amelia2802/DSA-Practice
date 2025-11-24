/*
    A mirror string is a string that looks the same when reversed AND when each character is replaced by its mirror counterpart.

    Mirror mapping (you must use only these characters):

    ```
    A ↔ A  
    H ↔ H  
    I ↔ I  
    M ↔ M  
    O ↔ O  
    T ↔ T  
    U ↔ U  
    V ↔ V  
    W ↔ W  
    X ↔ X  
    Y ↔ Y  

    0 ↔ 0  
    1 ↔ 1  
    8 ↔ 8
    ```

    Given a string `s`, return true if:

    * after removing non-alphanumeric characters
    * converting to uppercase
    * the string becomes a mirror string

    Otherwise, return false.

---

## 🔹 Examples

### **Example 1**

Input:
`s = "A8,8A"`

Process:
Clean → `"A88A"`
Mirror reverse → `"A88A"`
Matches.

Output:
`true`

---

### **Example 2**

Input:
`s = "WOW!"`

Clean → `"WOW"`
Mirror reverse → `"WOW"`
Matches.

Output:
`true`

---

### **Example 3**

Input:
`s = "HELLO"`

Clean → `"HELLO"`
Reverse → `"OLLEH"`
Mirror map → not valid
Not a mirror string.

Output:
`false`


*/

import java.util.*;

public class ValidMirrorString {

    public static boolean isValidMirrorString(String s){
        /*
            for my primary approach first we create a character set and populate with it mirror alpha numeric characters
            then remove extra spaces and special characters from the string and check if the string is palindrom and if it only contains mirror characters
            if any of the condition fails return false otherwise true
        */

        HashSet<Character> mirrorSet = new HashSet<>();
        Collections.addAll(mirrorSet,'A', 'H', 'I', 'M', 'O', 'T', 'U', 'V', 'W', 'X', 'Y', '0', '1', '8');

        s = s.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();

        int i = 0;
        int j = s.length()-1;

        while(i<j){
            if(!mirrorSet.contains(s.charAt(i)) || !mirrorSet.contains(s.charAt(j)) || s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Input:");
        String inputStr = sc.nextLine();
        System.out.println(isValidMirrorString(inputStr));
        sc.close();
    }
}
