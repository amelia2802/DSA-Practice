/*
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

@author Amazon, Google, Microsoft, Facebook (Meta), Apple, Bloomberg, Uber, LinkedIn

T.C:O(n)
S.C:O(n)
 */
import java.util.*;

class ValidParanthesis{
    public static boolean isValid(String s) {
        Stack<Character> tempStk = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch=='(' || ch=='{' || ch=='['){
                tempStk.push(ch);
                continue;
            }
            else{
                if(tempStk.isEmpty()){
                    return false;
                }

                if((ch==')' && tempStk.peek()=='(') || (ch=='}' && tempStk.peek()=='{') || (ch==']' && tempStk.peek()=='[')){
                    tempStk.pop();
                }
                else{
                    return false;
                }
            }
        }

        return tempStk.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));

        s = "(]";
        System.out.println(isValid(s));
    }
}