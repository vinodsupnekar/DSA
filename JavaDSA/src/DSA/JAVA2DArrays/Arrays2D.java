package DSA.JAVA2DArrays;

import java.util.Arrays;

public class Arrays2D {
    public static void main(String[] args) {
		 System.out.println("Hello World");
        // int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
        // int[][] A =   {{-83,-73,-70,-61},{-56,-48,-13,4},{38,48,71,71}};
        
        // {
        //     {-5, -4, -3},
        // {-1,  2,  3},
        // {2,  2 , 4}};
       

    //    -12  -7  -3 
    //      4  5  3
    //      8 6  4
    
    //        0      4    4
    //        12    11   7
    //        8   6  4
        // int[] B = {1};
        // int[] C =  {1};
        // int[] D = {2};
        // int[] E = {2};

        // int[] cc = Arrays2D.getSumOfSubArray(A, B, C, D, E);
        // int cc = Arrays2D.getElementInArray(A, 2);
        // int sum = Arrays2D.getMaxSubArraySumInSortedArray(A);

    //    int[][] A =  {
    //     {2, 3, 4, 5},
    //    {2, 3, 4, 5},
    //     {2, 3, 4, 5},
    //      {2, 3, 4, 5}};
       
    //    {
    //     {1, -1, 1, -100, -1},
    //     {2, -2, 2, -100, -2},
    //     {3, -8, 6, -70, -3},
    //     {4, -4, 4, -90, -4},
    //     {5, -5, 5, -80, -5}
    //    };
       //{{1, 2, 3}, {1 ,2, 3}, {5 ,  6 , 7}}; //{ {2, 2}, {2, 2}};
    
        // int B = 2;
        // int sum = Arrays2D.getMaxSumIn_B_B_subarray(A, B);
        int[] A = {1,10,20,30,40,2,33,3,44,55,8,100,100,100,100,1,22,33,44,55,3}
;        //{5,17,100,11}; 
        int B = 10;
        int sum = Arrays2D.get_MinSwaps(A, B);

         System.out.println(sum);
	}

    public static int get_MinSwaps(int[] A, int B) {
        int diff = 0;
        int noOfElements = 0;
        int maxGap = 0;
        int prevIndx = 0;
        int startIndx = 0;
        for(int i = 0; i< A.length; i++) {
            if (A[i] <= B) {
                noOfElements += 1;
            }
        }
        maxGap = noOfElements - 2;
        for(int i = 0; i< A.length; i++) {
            if (A[i] <= B) {
                startIndx = i;
                if (startIndx > (prevIndx + 1)) {
                    int currentDiff = startIndx  - (prevIndx + 1);
                    if (currentDiff <= maxGap && diff < currentDiff) {
                        diff = currentDiff;
                    }
                }
                prevIndx = startIndx;
            }
        }
        int swaps = 0;
        if ((diff <= (noOfElements - 2)) && (diff > 0)) {
            swaps += diff + (noOfElements - 2 - diff);
        } else {
            swaps = noOfElements - 1;
        }
    return swaps;
    }
    

    public static  int[] getSumOfSubArray(int[ ][ ] A , int[] B, int[] C,int[] D, int[] E) {
        int rows = A.length;
        int columns = A[0].length;
        int[ ][ ] pSum = new int[rows][columns];
        int[] result = new int[B.length];

	    for(int i = 0; i < rows; i++){
             pSum[i][0] = A[i][0];
	     for(int j = 1; j < columns; j++) {
		    double fsum = (double)A[i][j] + (double)(pSum[i][j - 1]);
            int sum = (int)(fsum % (double)1000000007.0);
            pSum[i][j] = sum;
         }
        }

        for(int j = 0; j < columns; j++) {
            //  pSum[i][0] = A[i][0];
	     for(int i = 1; i < rows; i++) {
		    double fsum = (double)pSum[i][j] + (double)(pSum[i - 1][j]);
            int sum = (int)(fsum % (double)1000000007.0);
            pSum[i][j] = sum;
         }
        }

         for(int i = 0; i < B.length; i++){
            int topIndex = B[i] - 1;
            int leftIndex = C[i] - 1;
            int bottomIndex = D[i] - 1;
            int rightIndex = E[i] - 1;
            int sum = 0;
            if (leftIndex > 0 && topIndex > 0) {
                double fsum = (double)(pSum[bottomIndex][rightIndex]) -  (double)(pSum[bottomIndex][leftIndex - 1])
                - (double)(pSum[topIndex - 1][rightIndex]) + (double)(pSum[topIndex - 1][leftIndex - 1]);
                 sum = (int)(fsum % (1000000007.0));
            } else if (leftIndex > 0 && topIndex == 0) {
                    double fsum = (double)pSum[bottomIndex][rightIndex] - (double)pSum[bottomIndex][leftIndex - 1];
                    sum = (int)(fsum % (1000000007.0));
            }
            else if (leftIndex == 0 && topIndex > 0) {
                    double fsum = (double)pSum[bottomIndex][rightIndex] - (double)pSum[topIndex - 1][rightIndex];
                 sum = (int)(fsum % (1000000007.0));
                }
            else
                 if (leftIndex == 0 && topIndex == 0) {
                    double fsum = (double)pSum[bottomIndex][rightIndex];
                  sum = (int)(fsum % (1000000007.0));
                }
                if (sum > 0) {
                    result[i] = sum;
                } else {
                        result[i] = (int)((long)sum + (1000000007L));
                }
            }
        return result;
    }

    public static int getElementInArray(int[][] A, int B) {
        int i = 0;
        int j = A[0].length - 1;
        while (i < A.length && j >= 0) {
            if (A[i][j] == B) {
                return ((i+1) * 1009) + j;
            } else if (B < A[i][j]) {
                j -= 1;
            } else if (B >  A[i][j]) {
                i += 1;
            }
        }
        return -1;
    }

    public static int getMaxSubArraySumInSortedArray(int[][] A) {
        
                int rows = A.length;
                int column = A[0].length;
                 int[][] pSum = new int[rows][column];
        
                for (int i = rows - 1; i >= 0; i--) {
                    pSum[i][column - 1] = A[i][column - 1];
                    for (int j = column - 2; j >= 0; j--) {    
                        pSum[i][j] = pSum[i][ j+ 1] + A[i][j];
                    }
                }
                for (int i = column - 1; i >= 0; i--) {
                    for (int j = rows - 2; j >= 0; j--) {    
                        pSum[j][i] = pSum[j + 1][i] + pSum[j][i];
                    }
                }
                int maxSubArraySum = Integer. MIN_VALUE;
                 for (int i = rows - 1; i >= 0; i--) {
                    for (int j = column - 1; j >= 0; j--) {    
                       if (pSum[i][j] > maxSubArraySum) {
                           maxSubArraySum = pSum[i][j];
                       }
                    }
                }
                return maxSubArraySum;
    }
        public static int getMaxSumIn_B_B_subarray(int[][] A, int B) {
    
            int rows = A.length;
            int columns = A[0].length;
            int[][] pSum = new int[rows][columns];
            int[][] b_b_sum = new int[rows - B + 1][columns - B + 1];
    
            for(int i = 0; i < rows; i++){
                 pSum[i][0] = A[i][0];
             for(int j = 1; j < columns; j++) {
                int sum = A[i][j] + pSum[i][j - 1];
                pSum[i][j] = sum;
             }
            }
    
            for(int j = 0; j < columns; j++) {
             for(int i = 1; i < rows; i++) {
                pSum[i][j] = pSum[i][j] + pSum[i - 1][j];
             }
            }
    
            int maxSubArraySum = Integer. MIN_VALUE;
                for (int i = 0; i <= rows - B; i++) {
                    int a2 = i + B - 1;
                    int a1 = i;
                for (int j = 0; j <= columns - B; j++) {
                    int b2 = j + B - 1;  
                    int b1 = j;   
                    if (a1 > 0 && b1 > 0){
                        b_b_sum[i][j] = pSum[a2][b2] - pSum[a2][b1 - 1] - pSum[a1 - 1][b2] + pSum[a1 - 1][b1 - 1];
                    } else if (a1 > 0 && b1 == 0){
                        b_b_sum[i][j] = pSum[a2][b2] - pSum[a1 - 1][b2];
                    } else if (a1 == 0 && b1 > 0){
                        b_b_sum[i][j] = pSum[a2][b2] - pSum[a2][b1 - 1];
                    }
                    else if (a1 == 0 && b1 == 0){
                        b_b_sum[i][j] = pSum[a2][b2];
                    }

                    if (maxSubArraySum < b_b_sum[i][j]) {
                        maxSubArraySum = b_b_sum[i][j];
                    }
                }
            }
            if (B == A.length) {
                return pSum[rows - 1][columns - 1];
            }
            return maxSubArraySum ;
        }
    
    
}
