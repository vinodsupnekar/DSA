package Tests.Advanc_1_Test;

import java.util.Arrays;

import DSA.Arrays.Advance_Arrays_2D;
import Sorting.SelectionSort;

public class MissingNum {

  public int firstMissingPositive(int[] A) {
    
        for(int i =0 ; i< A.length; i++) {
            while((A[i] >= 0) && (A[i] <= A.length) && (A[i] != (i+1))) {
                int index = A[i]-1;
                if (index > 0 && index < A.length) {
                if (A[index] == A[i]) {
                    break;
                }
                 int temp = A[index];
                A[index] = A[i];
                A[i] = temp;
                }
            }
         
        }
        
         for(int i =0 ; i< A.length; i++) { 
            if (A[i] != (i+1)) {
                return i+1;
            }
             
         }
        return A.length + 1;
    }

    // 3 2 1 2
    // 0 1 2 3

    // 1 2 3 2
    // 0 1 2 3
    //

    public int firstMissingNaturalNumber_practice(int[] array) {
        int missingNumber = array.length+1;
        for(int i = 0; i<array.length; i++){

            while(array[i] !=(i+1)) {
              
                int currentValue = array[i];
                int actualIndex = currentValue-1;
                if ((currentValue < 0) || (actualIndex >= array.length) || (actualIndex < 0)) {
                    break;
                }
                if(currentValue == array[actualIndex]) {
                    break;
                }
                int temp = array[actualIndex];
                array[actualIndex] = currentValue;
                array[i] = temp;
            }
        }
        for(int i = 0; i<array.length; i++){
            if(array[i] != i+1) {
                return i+1;
            }
        }
        return missingNumber;
    }

    public int rotateAndCheck(int[] A) {
        int[] a;
        int[] b;
        int[] c;
        for(int i = 1; i<A.length; i++) {
                    
            a = Arrays.copyOfRange(A, 0, i);

            b = Arrays.copyOfRange(A, i+1,  A.length-1);

             a = reverse(a);
             b = reverse(b);
             c = MissingNum.concatWithArrayCopy(a, b);
             
             for(int j = 1; j<c.length; j++) {
                 if(A[j] >= A[j-1]) {
                     return 0;
                 }
             }
       }
       return 1;
    }
    
    public int[] reverse(int[] A) {
        int l = 0;
        int r = A.length;
        while(l <= r) {
            int temp = A[l];
            A[l] = A[r];
            A[r] = temp;
            l++;
            r--;
        }
        return A;
    }
    
    static int[] concatWithArrayCopy(int[] array1, int[] array2) {
        int[] result = Arrays.copyOf(array1, array1.length + array2.length);
         System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }



    public static void main(String[] args) {   

        // Integer[] array = { 2, 100, 4};
        // List<Integer> list = Arrays.asList(array);
        // int k = new SelectionSort().kthsmallest(list,3);
        // int[] arr = {1};
        // //  int k = new MissingNum().firstMissingPositive(arr);
        //  int kk = new MissingNum().firstMissingNaturalNumber_practice(arr);
        // System.out.println(kk);

        int[] arr = {7,9,10};
        //  int k = new MissingNum().firstMissingPositive(arr);
         int kk = new MissingNum().rotateAndCheck(arr);
        System.out.println(kk);
    }

}
