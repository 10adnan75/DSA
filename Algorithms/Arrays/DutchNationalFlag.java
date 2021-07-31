// 0 -> Red
// 1 -> White
// 2 -> Blue

import java.io.*;   

class DutchNationalFlag {
    
    static void DNF(int[] arr, int size) {   
        int low = 0;   
        int high = size - 1;   
        int mid = 0, temp = 0; 
        while (mid <= high) {   
            switch (arr[mid]) {  
                case 0:    
                    temp = arr[low];   
                    arr[low] = arr[mid];   
                    arr[mid] = temp;   
                    low++;   
                    mid++;   
                    break;  
                
                case 1: 
                    mid++;   
                    break;
                
                case 2: 
                    temp = arr[mid];   
                    arr[mid] = arr[high];   
                    arr[high] = temp;   
                    high--;   
                    break;   
            }   
        }   
    }   

    static void printArray(int[] arr, int size) {   
        for (int i=0; i<size; i++)   
        System.out.print(arr[i] + " ");   
    }   

    public static void main (String[] arguments) {   
        int[] arr = {0, 1, 0, 1, 2, 0, 1, 2};   
        int size = arr.length;   
        System.out.print("Array before executing the DNF's algorithm : ");   
        printArray(arr, size);   
        DNF(arr, size);   
        System.out.print("\nArray after executing the DNF's algorithm : ");   
        printArray(arr, size);   
    }   
}  

/*      OUTPUT:
        Array before executing the DNF's algorithm : 0 1 0 1 2 0 1 2 
        Array after executing the DNF's algorithm : 0 0 0 1 1 1 2 2 
 */
