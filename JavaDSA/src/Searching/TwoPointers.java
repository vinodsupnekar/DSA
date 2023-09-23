package Searching;

import java.util.Arrays;

public class TwoPointers {
    public int solve(int[] A, int B) {
        int k = 0;
        int j = 1;
        int diff = 0;
        int count = 0;
        Arrays.sort(A);
        while (j < A.length) {
            diff =  Math.abs(A[j] - A[k]);
            if(diff == B){
                count++;
                j++;
                k++;
            }
            else if(diff < B) {
                j++;
            }
            else {
                k++;
             if(k == j) {
                j++;
              }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TwoPointers twoPtr = new TwoPointers();
         int[] A = {1, 1, 1, 2, 2,2,2,2};
        int aa = twoPtr.solve(A, 0);
        System.out.println(aa);
    }

}
