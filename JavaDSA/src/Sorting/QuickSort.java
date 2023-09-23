package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort {

    public int solve(ArrayList<Integer> A) {
        quickSort(A, 0, A.size() - 1);

         for (int i = 0; i< A.size(); i++) {
            System.out.println(A.get(i));
        }

        int steps = 0;
       for (int i = 1; i< A.size(); i++) {
           if (A.get(i-1) >= A.get(i)) {
               steps = steps + (A.get(i-1) + 1) - A.get(i);
               A.set(i,  A.get(i-1) + 1);
           }
       }
       return steps;
       }

      public void quickSort(ArrayList<Integer> A, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partion(A, start, end);
        quickSort(A, start, pivot - 1);
        quickSort(A, pivot + 1, end);
    }

    public int partion(ArrayList<Integer> A, int start, int end) {
        int pivot = A.get(end);
        int j = start;
        for (int i = start; i< end; i++) {
            if(A.get(i) < pivot) {
                Collections.swap(A, i , j);
                j++;
            }
        }
        Collections.swap(A, end , j);
        return j;
    }

    public static void main(String[] args) {   
        int[] arry = {51,6,10,8,22,61,56,48,88,85,21,98,81,76,71,68,18,6,14,23,72,18,56,30,97,100,81,5,99,2,85,67,46,32,66,51,76,53,36,31,81,56,26,75,69,54,54,54,83,41,86,48,7,32,85,23,47,23,18,45,79,95,73,15,55,16,66,73,13,85,14,80,39,92,66,20,22,25,34,14,51,14,17,10,100,35,9,83,31,60,24,37,69,62};

       ArrayList<Integer> A = new ArrayList<Integer>(arry.length);

        for (int i : arry)
        {
            A.add(i);
        }

    //    A.add(7);
    //    A.add(4);
    //    A.add(1);
    //    A.add(0);
    //     A.add(2);
        //[51,6,10,8,22,61,56,48,88,85,21,98,81,76,71,68,18,6,14,23,72,18,56,30,97,100,81,5,99,2,85,67,46,32,66,51,76,53,36,31,81,56,26,75,69,54,54,54,83,41,86,48,7,32,85,23,47,23,18,45,79,95,73,15,55,16,66,73,13,85,14,80,39,92,66,20,22,25,34,14,51,14,17,10,100,35,9,83,31,60,24,37,69,62]
        //1 1 2 4 4
        //1 2 3 5 4
        //0 1 1 1 1
        //

        //1 100  100 110
        //1 100  101 110
       QuickSort qk = new QuickSort();

       int k = qk.solve(A);
        System.out.println(k);
        // new QuickSort().quickSort(A, 0, A.size() - 1);

        // for (int i = 0; i< A.size(); i++) {
        //     System.out.println(A.get(i));
        // }
    }
    
}
