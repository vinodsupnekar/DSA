package PrimeNumbers;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {
    
    public ArrayList<Integer> allPrimes(int A) {
        
     List<Boolean> primes=new ArrayList<Boolean>(A);
     ArrayList<Integer> primeList = new ArrayList<Integer>();
    primes.add(false);
    primes.add(false);
    
     for(int i = 2; i <= A; i ++) {
        primes.add(true); 
     }

    for(int i = 2; i * i <= A; i ++) {
        if (primes.get(i) == true) {
             for(int j = i * i; j <= A; j = j + i) {
                 primes.set(j, false);
             }
        }
     }

    for(int i = 0; i <= A; i ++) {
         if (primes.get(i) == true) {
            primeList.add(i); 
         }
     }
    return primeList;
    
    }

    public static int[] createSpf(int A) {
        int[] primesSmallest = new int[A + 1]; 
// 0 1 2 3 4 5 6 7 8 9 10
// spf[N]
// 0 1 2 3 4 5 6 7 8 9 10 
// 0 1 2 3 2 3  2  3  2  2
        for(int i = 0; i <=A; i++) {
            primesSmallest[i] = i;
        }
        for(int i = 2; i * i < A; i++) {
            if (primesSmallest[i] == i) {
             for(int j = i * i; j <= A; j = j + i) {
                    if (primesSmallest[j] == j) {
                      primesSmallest[j] = i;
                    }
                }
            }     
        }
        return primesSmallest;
    }

     public static int[] createSpfOnArray(int[] A) {
        int[] primesSmallest = new int[A.length]; 
        for(int i = 0; i < A.length; i++) {
            primesSmallest[i] = A[i];
        }

        for(int k = 0; k < primesSmallest.length; k++) {
            int firstElement = primesSmallest[k];
            for(int i = 2; i * i <= firstElement; i++) {
                if (firstElement % i == 0) {
                    primesSmallest[k] = i;
                    break;
                }     
            }
        }
        return primesSmallest;
    }

    public static int getSpf(int A) {
        int primeMin = A;
            for(int i = 2; i * i <= A; i++) {
                if (A % i == 0) {
                    primeMin = i;
                    break;
                }     
            }
        
        return primeMin;
    }

    //Dry run
    /*
    N = 10
    min = 2;
    N > 1, 
        10> 2 -- 
            count = 1
            N = 5

            minSpf = 5
            fact = 2
            count = 0

            5%5 == 0 --
            N = 1
            count = 1

            fact = 2 * 2 = 4;


        
    * */

     public static int[] countOfFactors(int[] A) {
        int[] primesSmallest = createSpfOnArray(A); 
        int[] countOfFact = new int[primesSmallest.length];
      
        int factors = 1;

        for(int i = 0; i < primesSmallest.length; i++) {
           int N = A[i];
           int minSpf = primesSmallest[i];
           int count = 0;
            while(N > 1) {
                if ((N % minSpf) == 0) {
                      N = N / minSpf;
                    count += 1;
                } else {
                     minSpf = getSpf(N);
                     factors = factors * (count + 1);
                     count = 0;
                }
            }
            factors = factors * (count + 1);
            countOfFact[i] = factors;
             factors = 1;
        }

       
        return countOfFact;
    }

// Dry run:- 
// 5
// i - 0 1 2 3  4 5 6 7 8 9 10
// spf-0 1 2  3 2 5 2 7 2 3 2
// 

    public static void main(String[] args) {
        // int[] arry =  {17, 100, 11};//{1,2,3,1,2};
        // int num = 20;
        // PrimeNumber obj = new PrimeNumber();
        // ArrayList<Integer> modSum = obj.allPrimes(num);

        // for(int i = 0; i < modSum.size(); i++) {
        // System.out.println(modSum.get(i));
        // }

        // int A = 10;
        // int[] arry = PrimeNumber.createSpf(A);
        //  for(int i = 0; i < arry.length; i++) {
        // System.out.println(arry[i]);
        // }

        // int[] A  = {10, 17, 15};
        // int[] arry = PrimeNumber.createSpfOnArray(A);
        //  for(int i = 0; i < arry.length; i++) {
        //     System.out.println(arry[i]);
        // }

        int[] A  =  {20,39,29,51,96,32,35,50,57,7,59,51,85,55,8,26,15,4,4,18,32,49,40,46,83,77,100,92};//{2,3,4,5};//{10,20};
        // 2^2 * 5;
        //
        // 2 2 5
        // 1 4 5
         //1 2 5
        // 1 1 1
        // 2 1 1
        // 2 2 1
        // 1 1 5

         // 20 = 1 2 4 5 10 20 
        
        int[] arry = PrimeNumber.countOfFactors(A);
         for(int i = 0; i < arry.length; i++) {
            System.out.println(arry[i]);
        }
        

        
    }
}
