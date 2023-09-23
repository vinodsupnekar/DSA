package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import PrimeNumbers.PrimeNumber;

public class Recusion_1 {
     static ArrayList<ArrayList<Integer>> primeListArrayList = new ArrayList<ArrayList<Integer>>();

    public static   ArrayList<ArrayList<Integer>> solve(int A, int B) {
    ArrayList<Integer> primeList = new ArrayList<Integer>();
    if (A < B) {
      return primeListArrayList;
    }
     recusivePairs(A, B, primeList);
       return primeListArrayList;
     }

    public static ArrayList<ArrayList<Integer>> recusivePairs(int A, int B, ArrayList<Integer> primeList) {

     int trail = 1;
     if (primeList.size() >= 1) {
      trail =  primeList.get(primeList.size() - 1); //- '0';//primeList(primeList.length() - 1);
      trail += 1;
     }
     if (primeList.size() == B ) {
      //  for (int i = 0; i < primeList.size(); i++) {
      //    System.out.println(primeList.get(i));
      //  }
       primeListArrayList.add(primeList);
        return  primeListArrayList;
     } 
     while( trail <= A) {
         ArrayList<Integer> newPrimeList = new ArrayList<Integer>();
          newPrimeList = (ArrayList<Integer>)primeList.clone();
            newPrimeList.add(Integer.valueOf(trail));
           trail = trail + 1;
          recusivePairs(A, B,newPrimeList);

     }
     return primeListArrayList;
    }

    public static  ArrayList<Integer> createArrayListFrom(ArrayList<Integer> str) {
         ArrayList<Integer> array = new ArrayList<Integer>();
      for (int i = 0; i < str.size(); i++) {
        array.add( str.get(i));
      }
      return array;
    }

        public static void main(String[] args) {
        
      //   ArrayList<Integer> arry = 
        ArrayList<ArrayList<Integer>> lst = Recusion_1.solve(2,1);
              System.out.println(Arrays.deepToString(lst.toArray()));

      //    for (int i = 0; i < lst.size(); i++) {
      //    System.out.println(lst.get(i));
      //  }
      //    for(int i = 0; i < arry.size(); i++) {
      //       System.out.println(arry.get(i));
      //   }
        

        
    }
    
}
