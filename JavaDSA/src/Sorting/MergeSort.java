package Sorting;

import java.util.ArrayList;

public class MergeSort {
 
    public int getReversePairs(int[] A) {
        return reversePairs(A, 0, A.length-1);
    }

    public int reversePairs(int arr[], int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l + r) / 2;
        int leftReversePairs = reversePairs(arr, l, mid);
        int rightReversePairs = reversePairs(arr, mid + 1, r);
        int mergedCount = reversePairsMerge(arr, l, mid+1, r);
        return leftReversePairs + rightReversePairs + mergedCount;
    }

    public int reversePairsMerge( int[] A, int l, int y, int r) {
        int count = 0;
        int i = l;
        int j = y;
        int k = 0;
        int[] c = new int[r-l+1];

        while(i < y && j <= r) {
              if((long)A[i] <= (long)(2l * A[j])){
               i++;
              }
              else {
                j++;
                count = count + (y - i);
               }
        }
        i = l;
        j = y;
        while(i < y && j <= r) {
         if(A[i] < A[j]){
            c[k] = A[i];
                i++;
            k++; 
         }
         else {
            c[k] = A[j];
            j++;
            k++; 
         }
      }
      while( i < y) {
            c[k] = A[i];
            i++;
            k++; 
      }
       while( j <= r) {
            c[k] = A[j];
            j++;
            k++; 
      }

      k = 0;
      for(int ll = l; ll <= r; ll++){
          A[ll] = c[k]; 
          k++;
      }
        return count;
    }   

     public static void main(String[] args) {   
        int[] arry = {1,3,2,3,1};
        
       ArrayList<Integer> A = new ArrayList<Integer>(arry.length);

        for (int i : arry)
        {
            A.add(i);
        }
        MergeSort mg = new MergeSort();
        int k = mg.getReversePairs(arry);
        System.out.println(k);
    }

}
