/*
 * You have a large array with most of the elements as zero.
 * Use a more space-efficient data structure, SparseArray, that implements the same interface:
 * init(arr, size): initialize with the original large array and size.
 * set(i, val): updates index at i with val.
 * get(i): gets the value at index i.
 * 
 * @author Facebook
 * 
 * T.C:O(1)
 * S.C:O(n)
 * 
 * Topic:Hashing
 */

import java.util.HashMap;

public class SparseArray {
    HashMap<Integer, Integer> map;
    int size;

    public void init(int[] arr, int size) {
        this.map = new HashMap<>();
        this.size = size;
        for (int i = 0; i < size; i++) {
            if (arr[i] != 0) {
                map.put(i, arr[i]);
            }
        }
    }

    public void set(int i, int val) {
        if (val == 0) {
            map.remove(i);
        } else {
            map.put(i, val);
        }
    }

    public int get(int i) {
        return map.getOrDefault(i, 0);
    }
    public static void main(String[] args) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.init(new int[]{0, 0, 1, 2, 0, 0, 0, 3, 0, 4}, 10);

        System.out.println(sparseArray.get(0));
        System.out.println(sparseArray.get(3));
        System.out.println(sparseArray.get(9)); 
        sparseArray.set(3, 0);
        System.out.println(sparseArray.get(3)); 
    }
}
