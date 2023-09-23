package ModularArithmetic_1;

import java.util.HashMap;

import DSA.JAVA2DArrays.Interval;

public class ModularArithmetic {

    public static int solve(int[] A) {

    HashMap<Integer, Integer> map = frequency(A);

    for (HashMap.Entry<Integer, Integer> hm : map.entrySet()) {
        System.out.println( " key ==  value" +  hm.getKey() + " " + map.get(hm.getKey()));
        }

    int totalSum = 0;
    int sum = 0;
    for (HashMap.Entry<Integer, Integer> hm : map.entrySet()) {
        sum = 0;
          for (int i = 0; i < A.length; i++) {
             sum += hm.getKey()%A[i];
          }
          totalSum += sum * map.get(hm.getKey());
    }
    return totalSum;
    }

    public static HashMap<Integer, Integer> frequency(int[] A) {
         HashMap<Integer,Integer> hm =  new HashMap<>();

         for (int i = 0; i < A.length; i ++){
             if (!hm.containsKey(A[i])) {
                  hm.put(A[i], 1);
             } else {
                hm.put(A[i], hm.get(A[i]) + 1 );
             }
        }
        return hm;
    }

    public static int deleteOne(int[] A) {

            // int ans = A[0];
            // for (int i = 1; i < A.length; i++) {
            //     ans = gcd(ans, A[i]);
            // } 
            int[] prefixGCD = new int[A.length];
            prefixGCD[0] = A[0];
                for (int i = 1; i < A.length; i++) {
                prefixGCD[i] = gcd( prefixGCD[i - 1],A[i]);
            }

            int[] suffixGCD = new int[A.length];
            suffixGCD[A.length - 1] = A[A.length - 1];
            int i = A.length - 2;
            while( i >= 0) {
                suffixGCD[i] = gcd(suffixGCD[i + 1],A[i]);
                i--;
            }

            int finalans = 0;
            if (A.length == 2) {
            if (A[0] > A[A.length - 1]) {
                 finalans = A[0];
                }  else {
                finalans = A[A.length - 1];
                }
            } else {
                finalans = 0;
            }
                for (int j = 1; j < A.length - 1; j++) {
                    int currenrGCD = gcd( prefixGCD[j - 1],suffixGCD[j + 1]);
                    if (finalans < currenrGCD ){
                    finalans = currenrGCD;
                    }
            }
            return finalans;
    }


    public  static int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }

    public static void main(String[] args) {
        int[] arry = {21,7,3,42,63} ;// {21, 7} ; //; // ;//;//{16 ,8, 4};//{1,2,3,1,2}; p = 16 8 4  s = 4 4 4  4  
        //[10, 20] ==>  [10, 20, 30]  --> (20, 30) - 10, (10,30) --> 10, (10, 20)== 10 , ans = 10
        // e1 = 10  e2 = 30 , ans = gcd(10, 30) = 10
        // pf = [10, 10, 10]
        // sf = [ 10  10 30]
        //  i == 1 --> gcd(pf[0], sf[2]) --> gcd(10, 30) == 10
        
        // {21,7,3,42,63} :- (21, 63) ==> ans = 21
        // 
        int maxGCD = deleteOne(arry);
        System.out.println(" maxGCD  " + maxGCD );

        // for(int i = 0; i < arry.length; i++) {
        // System.out.println(arry[i] + " and  " + arry[i].end);
        // }
    }
}