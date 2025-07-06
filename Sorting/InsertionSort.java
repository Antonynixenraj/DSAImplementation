package Sorting;

public class InsertionSort {
    public static int[] insertion(int arr[]){
        for (int i = 0; i < arr.length-1; i++) {    
            for(int j=i+1;j<arr.length && arr[i]>arr[j];j++){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        return arr;
    } 
    public static void insertionSort(int arr[]){
        for(int i=1;i<arr.length;i++){
            int temp=arr[i];
            int j=i-1;
            while(j<arr.length && arr[j]>temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
    }
}