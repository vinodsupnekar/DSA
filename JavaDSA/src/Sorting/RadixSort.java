package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RadixSort {
      public ArrayList<Integer> countSort(ArrayList<Integer> A) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > max) {
                max = A.get(i);
            }
        }
        ArrayList<Integer> frequency = new ArrayList<Integer>(max + 1);
        for (int i = 0; i < max + 1; i++) {
            frequency.add(0);
        }
          for (int i = 0; i <  A.size(); i++) {
              int k = A.get(i);
              int l = frequency.get(k) + 1;
              frequency.set(k, l);
             
          }
            int indx = 0;                               
           for (int i = 0; i < frequency.size(); i++) {
                for (int j = 0; j < frequency.get(i); j++) {
                    A.set(indx, i);
                    indx++;
                }
           }
           return A;
    }

    public long fatsPower(int a) {
        if (a == 0) {
            return 1;
        }
        if ((a & 1) == 0) {
            return (((long)fatsPower(a/2) * (long)fatsPower(a/2)) % 1000000007);
        } 
        else {
             return (((((long)2 * (long)fatsPower(a/2)) % 1000000007)  * (long)fatsPower(a/2)) % 1000000007); //a * fatsPower(a/2) * fatsPower(a/2);
        }

    }

    public int findMaxMinumMinDifferenceInSubsetOfArray(ArrayList<Integer> A) {
        int maxAll = 0;
        int minAll = 0;
        A.sort(Comparator.naturalOrder());

        for(int i = 0; i < A.size(); i++) {
            maxAll = maxAll + (int)(((long)A.get(i) * fatsPower(i)) % 1000000007);
            minAll = minAll +  (int)(((long)A.get(i) * fatsPower(A.size() - 1 - i)) % 1000000007);
        }
        return maxAll - minAll;
    }
        // [1 2 3]  
        //  0 1 2
        // n-1 - 
        // 2 - 1
        // subsets with 2 as max element [1], [1,2]
        // contribution of 2 in maxAll = 2 * 2^2

        //subsets with 2 as min element  [3,2], [1,2,3]
          // contribution of 2 in minAll = 2 * 2^2 = 


    public static void main(String[] args) {   

    //     Integer[] array = { 1, 2, 3, 0, 0, 6,5,5,1,100,50,50 };
    //      ArrayList<Integer> list =  new ArrayList<Integer>(array.length);
        
    //    for (int i = 0; i < array.length; i++) {
    //         list.add(array[i]);
    //    }
    
       RadixSort srt = new RadixSort();
        // ArrayList<Integer> k = new RadixSort().countSort(list);
        //   for (int i : k)
        // {
        //            System.out.println(i);

        // }
        /* 3 5 10
         * [3] []
         * [3,5] [3] , [5] ,[]
         * [3,5,10], [3,5],[3], [3,10] [5,10] [5], [10],[]
         * 
         * 3 - max in 1(i.e [3])  =  3*1 = 3
         * 3 min in - 4 . 3*4 = 12 
         *  max = 3
         * min = 12
         * 
         * 5 - max in = 1 time = 5* 1 = 5
         * 5 - min in =  2 time = 5*2 = 10 
         * max = 5 + 3 = 8
         * min = 12 + 10 = 22
         * 
         * 10 - max in 4 =  time = 10* 4 = 40
         * 10 - min in  1 =   time = 10*1 =  10
         * 
         * max = 8 + 40 = 48
         * min = 22 + 10 = 32
         * 
         * max - min = 48 - 32 = 15
         * [3], [3,5], 3][3 5 10]
         * 
         */
        ArrayList<Integer> listMinMaxDiff =  new ArrayList<Integer>();

        listMinMaxDiff.add(1);
        listMinMaxDiff.add(2);
        // listMinMaxDiff.add(10);

        //[3, 5, 10]
        int a = srt.findMaxMinumMinDifferenceInSubsetOfArray(listMinMaxDiff);
         System.out.println(a);
    }
}
