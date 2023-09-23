package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Recursion.Recusion_1;

public class SelectionSort {
    
    public int kthsmallest(final List<Integer> A, int B) {

        List<Integer> AA = new ArrayList<>(A);    
        for(int i = 0;i < B; i++) {
            int min = AA.get(i);
            int indx = i;
             for(int j = i;j < AA.size(); j++) {
                 if (AA.get(j) < min) {
                     min = AA.get(j);
                     indx = j;
                 }
             }
              Collections.swap(AA, i, indx);
        }
        return AA.get(B-1);
    }

    public ArrayList<Integer> mergeTwoSortedArray(final List<Integer> A, final List<Integer> B) {
        
        ArrayList<Integer> C  = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < A.size() && j < B.size()) {
            int a = A.get(i);
            int b = B.get(j);
            if (a < b) {
                    C.add( k, a);
                    i++;
                    k++;
            } else {
                    C.add( k, b);
                    j++;
                    k++;
            }
        }
        while(i < A.size()) {
            int a = A.get(i); 
                C.add( k, a);
                    i++;
                    k++;
        }
        while(j < B.size()) {
                int b = B.get(j);
                C.add( k, b);
                j++;
                k++;
        }
        return C;
    }   


    // Approavh 1 :- inversionPairsMerge :- Gives TLE.
    public int inversionPairsMerge( int[] A, int l, int mid, int r) {
        
        int count = 0;
        int i = l;
        while(i <= mid) {
            int a = A[i];
           int j = mid + 1;
            while(j <= r) {
                int b = A[j];
                if (a > b) {
                    count++;
                } 
                j++;
            }
        i++;
      }
        return count;
    }   

     // Approavh 2 :-
        int  inversionPairs = 0;
    public int inversionPairsMergeSortVariation( List<Integer> A,  List<Integer> B){
        ArrayList<Integer> C  = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < A.size() && j < B.size()) {
            int a = A.get(i);
            int b = B.get(j);
            if (a < b) {
                    C.add( k, a);
                    i++;
                    k++;
            } else {
                   inversionPairs++;
                    C.add( k, b);
                    j++;
                    k++;
            }
        }
        while(i < A.size()) {
            inversionPairs = inversionPairs + ( B.size() - i + 1);
            int a = A.get(i); 
                C.add( k, a);
                    i++;
                    k++;
        }
        while(j < B.size()) {
                int b = B.get(j);
                C.add( k, b);
                j++;
                k++;
        }
        return C;
    }


    public int inversionPairsMergeSortVariationRecursion( List<Integer> arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l + r) / 2;
        int leftInversionPairs = inversionPairsMergeSortVariationRecursion(arr, l, mid);
        int rightInversionPairs = inversionPairsMergeSortVariationRecursion(arr, mid + 1, r);
        int count = inversionPairsMergeSortVariation(arr, l, mid, r);
        return leftInversionPairs + count + rightInversionPairs;
    }


    public int inversionPairs(int arr[], int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l + r) / 2;
        int leftInversionPairs = inversionPairs(arr, l, mid);
        int rightInversionPairs = inversionPairs(arr, mid + 1, r);
        int mergedCount = inversionPairsMerge(arr, l, mid, r);
        return leftInversionPairs + rightInversionPairs + mergedCount;
    }



    public static void main(String[] args) {   

        // Integer[] array = { 2, 100, 4};
        // List<Integer> list = Arrays.asList(array);
        // int k = new SelectionSort().kthsmallest(list,3);
        int[] arr = {3, 4, 1, 2};
         int k = new SelectionSort().inversionPairs(arr, 0, arr.length-1);
        System.out.println(k);
    }
    
}
