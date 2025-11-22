public class removeDuplicate {
    public static int removedElement(int arr[],int n){
        int k = 0;

        for(int i=1;i<n;i++){
            if(arr[k]!=arr[i]){
                k++;
                arr[k] = arr[i];
            }
        }

        return k+1;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{0,0,1,1,1,2,2,3,3,4};
        int n = arr.length;
        int k = removedElement(arr,n);

        for(int i=0;i<k;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
