package DSA.Arrays;

import Sorting.SelectionSort;

public class Advance_Arrays_2D {
    public int solve(int[] A, int B) {
        int minCount = 0;
        
    if (A.length == 1) {
        return 0;
    }
    for(int i = 0; i< A.length; i++) {
        if  (A[i] <= B) {
            minCount++;
        } 
    }
    int k = minCount;
    int windowMaxCount = 0;
    for(int i = 0; i< k; i++) {
        if  (A[i] > B) {
            windowMaxCount += 1;
        }
    }
    int e = k;
    int ans = windowMaxCount;
    int s = 1;
    while(e < A.length) {
        if  (A[s-1] > B) {
            windowMaxCount -= 1;
        }
        if  (A[e] > B) {
            windowMaxCount += 1;
        }
        ans = Math.min(windowMaxCount, ans);
    e++;
    s++;
    }
    return ans;
    }

     public static void main(String[] args) {   

    
        // int[] arr = {3, 4, 1, 2};
         int[] arr  = {52,7,93,47,68,26,51,44,5,41,88,19,78,38,17,13,24,74,92,5,84,27,48,49,37,59,3,56,79,26,55,60,16,83,63,40,55,9,96,29,7,22,27,74,78,38,11,65,29,52,36,21,94,46,52,47,87,33,87,70};
         int k = new Advance_Arrays_2D().solve(arr, 19);
        System.out.println(k);
    }
}
