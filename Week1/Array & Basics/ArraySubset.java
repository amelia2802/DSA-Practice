```
class Solution {
    public boolean isSubset(int a[], int b[]) {
        // Your code here
        HashMap<Integer,Integer> freqMap = new HashMap<>();

        for(int element : a){
            freqMap.put(element, freqMap.getOrDefault(element,0) + 1);
        }

        for(int item : b){
            if(!freqMap.containsKey(item) || freqMap.get(item) == 0){
                return false;
            }
            freqMap.put(item, freqMap.get(item) - 1);
        }
        
        return true;
    }
}
```
