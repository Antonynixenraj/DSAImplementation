package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static int[] selection(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++)
                min=arr[min]>arr[j]?j:min;
            int temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
        return arr;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(selection(new int[]{99,-1,2,55,2,33,4,5,6})));
        System.out.println(Arrays.toString(BubbleSort.bubble(new int[]{99,-1,2,55,2,33,4,5,6})));
        System.out.println(Arrays.toString(InsertionSort.insertion(new int[]{99,-1,2,55,2,33,4,5,6})));
        
    }
}
