/**
 * MegaCorp wants to give bonuses to its employees based on how many lines of codes they have written.
 * They would like to give the smallest positive amount to each worker consistent with the constraint that if a developer has written more lines of code
 * than their neighbor, they should receive more money.
 * Given an array representing a line of seats of employees at MegaCorp, determine how much each one should get paid.
 * For example, given [10, 40, 200, 1000, 60, 30], you should return [1, 2, 3, 4, 2, 1]
 * 
 * @author Atlassian
 * 
 * T.C: O(n)
 * S.C: O(n)
 * ```Topic:greedy algorithm```
 */

 import java.util.*;
 class GiveBonus{
    public static void main(String[] args) {
        int lineofCodes[] = {10,40,200,1000,60,30};
        int arrayLength = lineofCodes.length;
        int[] result = new int[arrayLength];
        Arrays.fill(result, 1); // Initialize each employee's bonus to 1

        for(int i = 0; i<=arrayLength-1;i++){
            int leftNeighbour = i-1 ;
            if(leftNeighbour >= 0 && lineofCodes[i] > lineofCodes[leftNeighbour]){
                result[i] = result[leftNeighbour]+1;
            }
        }

        for(int i = lineofCodes.length-2; i>=0;i--){
            int rightNeighbour = i+1 ;
            if(rightNeighbour <= arrayLength && lineofCodes[i] > lineofCodes[rightNeighbour]){
                result[i] = Math.max(result[i], result[rightNeighbour]+1);
            }
        }

        for(int i =0;i<arrayLength;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }
 } 