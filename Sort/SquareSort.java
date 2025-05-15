/*
 * Given a sorted list of integers, square the elements and give the output in sorted order.
 * For example, given [-9, -2, 0, 2, 3], return [0, 4, 4, 9, 81].
 * 
 * @author Google
 * 
 * T.C:O(n)
 * S.C:O(n)
 * 
 * Topic: 
 */
import java.util.ArrayList;

public class SquareSort {
    public static ArrayList<Integer> sortedArray(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int[] result = new int[n];
        int index = n - 1;

        while (left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];

            if (leftSquare > rightSquare) {
                result[index--] = leftSquare;
                left++;
            } else {
                result[index--] = rightSquare;
                right--;
            }
        }

        ArrayList<Integer> outputArr = new ArrayList<>();
        for (int num : result) {
            outputArr.add(num);
        }
        return outputArr;
    }

    public static void main(String[] args) {
        int inputArray[] = {-9, -2, 0, 2, 3};

        System.out.println(sortedArray(inputArray));
    }
}
