/**
 * An array is a data structure that stores elements of the same type in a contiguous block of memory. In an array, , of size , each memory location has some unique index,  (where ), that can be referenced as  or .

Your task is to reverse an array of integers.

Note: If you've already solved our C++ domain's Arrays Introduction challenge, you may want to skip this.

Example

Return .

Function Description

Complete the function  with the following parameter(s):

: the array to reverse
Returns

: the reversed array
Input Format

The first line contains an integer, , the number of integers in .
The second line contains  space-separated integers that make up .

Constraints
.
Sample Input 1

CopyDownload
Array: arr
1
4
3
2

 
4
1 4 3 2
Sample Output 1

2 3 4 1
Explanation 1

The original array is 1 4 3 2 . Reversed, it is 2 3 4 1.
 * 
 */

 import java.io.*;
 import java.util.*;
 import java.util.stream.*;
 import static java.util.stream.Collectors.joining;
 import static java.util.stream.Collectors.toList;
 
 class Result {
 
     /*
      * Complete the 'reverseArray' function below.
      *
      * The function is expected to return an INTEGER_ARRAY.
      * The function accepts INTEGER_ARRAY a as parameter.
      */
 
     public static List<Integer> reverseArray(List<Integer> a) {
     // Write your code here
         int i =0;
         int j = a.size()-1;
         while(i<=j){
            int temp = a.get(i);
             a.set(i, a.get(j));
             a.set(j, temp);
             i++;
             j--;
         }
         return a;
     }
 
 }
 
 public class ReverseArray {
     public static void main(String[] args) throws IOException {
         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
 
         int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
 
         List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
             .map(Integer::parseInt)
             .collect(toList());
 
         List<Integer> res = Result.reverseArray(arr);
 
         bufferedWriter.write(
             res.stream()
                 .map(Object::toString)
                 .collect(joining(" "))
             + "\n"
         );
 
         bufferedReader.close();
         bufferedWriter.close();
     }
 }
 
