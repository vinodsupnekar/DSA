package Two_Pointers;

public class TwoPointers {
    public int threeSumClosest(int[] A, int B) {
        int ans = Integer.MIN_VALUE;
        int firstNumber = 0;
        int targetSum = 0;
        for(int i = 0; i< A.length; i++) {
            firstNumber = A[i];
            targetSum = Math.abs(B - firstNumber);
            int k = pairSum(A, targetSum, i) + firstNumber;
            ans = Math.max(ans, k);
            if(ans == B) {
                return ans;
            }
        }
        return ans;
    }

     public int pairSum(int[] A, int B, int indexOfFirstElement) {
        int i = 0;
        int j = A.length - 1;
        int ans = Integer.MAX_VALUE;
        int lastdiff = Integer.MAX_VALUE;
        int sum = 0;
        while(i < j) {
            if(i == indexOfFirstElement){
                i++;
            }
            if((j == indexOfFirstElement)) {
                j--;
            }
            if(j < 0 || i > A.length || (i == j)) {
                break;
            }
             sum = A[i] + A[j];
             int currentDiff = Math.abs(B-sum);
            if(sum == B) {
                return sum;
            }
            else if(sum < B){
                i++;
            } 
            else {
                j--;
            }
            if(currentDiff < lastdiff) {
                ans = sum;
            }
        }
        return ans;
    }

    public static void main(String[] args) {   
        int[] arry = {-1,2,1,-4};
        TwoPointers qk = new TwoPointers();
        int kk = qk.threeSumClosest(arry, 1);
        System.out.println(kk);
    }
}
