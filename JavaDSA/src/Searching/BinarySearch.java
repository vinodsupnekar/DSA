package Searching;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
    public int searchInsert(ArrayList<Integer> A, int B) {
        int l = 0;
        int r = A.size() - 1;
        int mid = 0;
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        int k = 0;
        while(l <= r) {
            mid = (l + r) / 2;
            if (A.get(mid) == B) {
                return mid;
            }

            else if (A.get(mid) < B) {
                l = mid + 1;
            } 
            else if (A.get(mid) > B) {
                r = mid - 1;
            }
        }
        return l;
    }

    public int solve(ArrayList<Integer> A) {
        int mid = 0;
        int l = 0;
        int r = A.size()-1;
        int firstIndex = 0;
        int n = A.size() ;
        if(n == 1) {
            return A.get(0);
        }
         if(A.get(0).intValue() != A.get(1).intValue()) {
            return A.get(0);
        }
          Integer a = A.get(n-1);
          Integer b = A.get(n-2);
        if(a.equals(b) == false ) {
            return a;
        }
        while(l<=r) {
            mid = (l+r)/2;
            Integer midElement = A.get(mid);
            Integer midPrevious =  A.get(mid-1);
            Integer midNext = A.get(mid+1);
             if(((midElement.equals(midPrevious)) == false) && ((midElement.equals(midNext)) == false) ){
                 return A.get(mid);
             }
             firstIndex = mid;
            if ((midElement.equals(midPrevious)) == true){
                firstIndex = mid-1;
            }
            if((firstIndex % 2) == 0) {
                l = mid+1;
            } else {
                r = mid-1;
            }
             
        }
       return -1;
    }

    public int sqrt(int A) {
        int mid = 0;
        int l = 0;
        int r = A-1;
        int ans = 0;
        while(l<=r){
            mid = (l+r)/2;
            int square = mid*mid;
            if(square == A) {
                ans = mid;
                return ans;
            }
            else if(square < A){
                l = mid+1;
                ans = mid;
            }
            else if(square > A){
                r = mid-1;
            }
        }
        return ans;
    }
    
    
    public int searchMatrix(int[][] A, int B) {

        int l = 0;
        int r = A.length-1;
        int row = getRow(A, B,l, r);
        // For column wise search :- 
        l = 0;
        r =  A[0].length-1;
        int mid = 0;
        if (row >= 0) {
            while(l<=r){
            mid = (l+r)/2;
            if(A[row][mid] == B) {
                return 1;
            }
            else if(A[row][mid] < B) {
                l = mid+1;
            }
            else if(A[row][mid] > B) {
                r = mid-1;
            }
        }
        }
        return 0;
    }

    public int getRow(int[][] A, int B, int l, int r) {
        int column = A[0].length-1;
        while(l<=r){
         int mid = (l+r)/2;
            if (mid == 0) {
                if ( B <= A[mid][column] ){
                    return mid;
                } else {
                 l = mid+1;
            }
           }  else if(A[mid-1][column] < B && B <= A[mid][column]) {
                  return mid;
           }
           else if(A[mid][column] < B) {
                l = mid+1;
            }
            else if(A[mid][column] > B) {
                r = mid-1;
            }
        }
        return -1;
    }
    

    public int books(int[] A, int B) {
        // Arrays.sort(A);
        if(A.length < B){
            return -1;
        }
        int pages = A[0];
        int mid = 0;
        int ans = 0;
        int max = A[0];
        int count = 1;
       for(int i = 1; i< A.length; i++){
            pages += A[i];
            if(max < A[i]){
                max = A[i];
            }
        }
        int l = max;
        int r = pages;
        int sum = 0;
        while(l <= r){
            mid =(l + r) / 2;
           for(int i = 0; i< A.length ; i++){
                sum += A[i];
                if(sum > mid) {
                    count++;
                    sum = A[i];
                }
           }
            if(count == B) {
                //find better answer , move left
                ans = mid;
                r = mid;
            } else if (count < B) {
                // move left, as capacity of a stduent is so high , others dont get a book to read 
                r = mid;
            } else if( count > B) {
                // move right, as capacity of a stduent is so low , too many students needed to finish all books.
                l = mid+1;
            }
            sum = 0;
            count = 1;
       }
      return ans;
    }
    

     public static void main(String[] args) {
        
        BinarySearch brny = new BinarySearch();
        int[] A = {97,26,12,67,10,33,79,49,79,21,67,72,93,36,85,45,28,91,94,57,1,53,8,44,68,90,24};//{12,34,67,90};
        int aa = brny.books(A, 26);

        System.out.println(aa);

       
        // ArrayList<Integer> lst = new ArrayList<Integer>();
        // int[] arry = {13,13,21,21,27,50,50,102,102,108,108,110,110,117,117,120,120,123,123,124,124,132,132,164,164,166,166,190,190,200,200,212,212,217,217,225,225,238,238,261,261,276,276,347,347,348,348,386,386,394,394,405,405,426,426,435,435,474,474,493,493};
        //  int[] arry  = {512,512,519,519,527,527,528,528,538,538,544,544,557,557,586,586,589,589,602,602,618,618,629,629,630,630,658,658,672,672,680,680,694,694,695,695,708,708,713,713,720,720,731,731,735,735,748,748,750,750,779,779,801,801,815,815,840,840,854,854,868,868,875,875,879,879,881,881,912,912,929,929,935,935,968,968,971,971,979,979,982,982,983,983,987,987,994,994,1038,1038,1039,1039,1044,1044,1047,1047,1057,1057,1059,1059,1079,1079,1111,1111,1115,1115,1117,1117,1130,1130,1143,1143,1145,1145,1150,1150,1156,1156,1162,1162,1164,1164,1170,1170,1174,1174,1177,1177,1179,1179,1184,1184,1189,1189,1191,1191,1194,1194,1209,1209,1210,1210,1238,1238,1244,1244,1249,1249,1252,1252,1257,1257,1320,1320,1327,1327,1359,1359,1360,1360,1361,1361,1365,1365,1368,1368,1376,1376,1387,1387,1400,1400,1403,1403,1406,1406,1409,1409,1413,1413,1427,1427,1433,1433,1442,1442,1443,1443,1449,1449,1451,1451,1453,1453,1455,1455,1458,1458,1471,1471,1479,1479,1481,1481,1482,1482,1488,1488,1489,1489,1491,1491,1510,1510,1511,1511,1515,1515,1517,1517,1525,1525,1529,1529,1530,1530,1534,1534,1577,1577,1581,1581,1582,1582,1593,1593,1595,1595,1602,1602,1606,1615,1615,1635,1635,1642,1642,1665,1665,1681,1681,1693,1693,1695,1695,1709,1709,1716,1716,1717,1717,1719,1719,1736,1736,1744,1744,1772,1772,1776,1776,1784,1784,1787,1787,1788,1788,1809,1809,1825,1825,1843,1843,1860,1860,1861,1861,1865,1865,1873,1873,1892,1892,1903,1903,1904,1904,1915,1915,1918,1918,1929,1929,1937,1937,1943,1943,1945,1945,1953,1953,1965,1965,1966,1966,1982,1982,1983,1983};
        // for(int i = 0; i< arry.length; i ++) {
        //     lst.add(arry[i]);
        // }
        // int A = 1000000000;
        // int a = brny.sqrt(A);
        //  System.out.println(a);
       
        // int[][] A = {{10},{20}, {30}};
    //      int[][] A = {{5, 17, 100, 111},
    //   {119, 120, 127, 131}};
        
     }
}
