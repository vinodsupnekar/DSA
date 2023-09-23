package DSA.CombinationsAndPerm;

import PrimeNumbers.PrimeNumber;

public class Computations {

    static public int solve(int A, int B, int C) {
        // A == n
        // B = r
        // C = m
        long af = 1;
        for (int i = 1; i<= A; i++) {
            af = (af * i) % C;
        }

        long bf = 1;
        for (int i = 1; i<= B; i++) {
            bf = (bf * i) % C;
        }


        long aMbf = 1;
        for (int i = 1; i<= (A-B); i++) {
            aMbf = (aMbf * i) % C;
        }

        long x = fastPower(aMbf, C - 2, C);

        long y = fastPower(bf, C - 2, C);

        long ans = (((af * x) % C) * y ) % C;

        return (int)ans;
    }

     static int fastPower(long a, long n, int m) {
        if (n == 0) {
            return 1;
        }
        long p  = fastPower(a, n/2, m);
        if ((n % 2) == 0) {
            return (int) ((p * p) % m);
        } 
        else {
            return (int) ((((p * p) % m) * a) % m);
        }
    }

    public static void main(String[] args) { 
        int A = 6;
        int B = 2;
        int C = 13;

         int arry = Computations.solve(A, B, C);
        //  for(int i = 0; i < arry; i++) {
            System.out.println(arry);
        // }
    }
    
}
