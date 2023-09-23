package Hashing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import Sorting.MergeSort;

public class Treeset_1 {

    public ArrayList<Integer> solve(String A, ArrayList<ArrayList<Integer>> B) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i =0; i < A.length(); i++) {
            char character = A.charAt(i);
            if(character == '1') {
                treeSet.add(i+1);
            }
        }

        for (ArrayList<Integer> query : B) {
            int type = query.get(0);
            int x = query.get(1);

            if(type == 1) {
                if(treeSet.contains(x)) {
                     treeSet.remove(x);
                 } else {
                      treeSet.add(x);
                 }
            } 
            else {
            
                Integer right =  treeSet.higher(x);
                Integer left = treeSet.lower(x);

                if ((left == null) &&  (right == null)) {
                     ans.add(-1);
                     return ans;
                } else if (left == null) {
                     ans.add(right);
                } else if (right == null) {
                    ans.add(left);
                } else {
                     int leftDist = x - left;
                    int rightDist = right - x;
                   if(leftDist > rightDist) {
                       ans.add(right);
                    }else{
                         ans.add(left);
                    }
                }
            }
        }
        return ans;
    }

     public static void main(String[] args) {   
       String A =  "10010"; //"010000100";
      ArrayList<ArrayList<Integer>> listOfLists = new  ArrayList<ArrayList<Integer>>();

      Integer[] numbers = new Integer[] { 1,3 };
    List<Integer> list1 = Arrays.asList(numbers);
    listOfLists.add(new ArrayList<Integer>(list1));

      Integer[] numbers2 = new Integer[] { 1,3 };
    List<Integer> list2 = Arrays.asList(numbers2);
    listOfLists.add(new ArrayList<Integer>(list2));

      Integer[] numbers3 = new Integer[] { 2,4 };
    List<Integer> list3 = Arrays.asList(numbers3);
    listOfLists.add(new ArrayList<Integer>(list3));

      Integer[] numbers4 = new Integer[] { 2,2 };
    List<Integer> list4 = Arrays.asList(numbers4);
    listOfLists.add(new ArrayList<Integer>(list4));

      Integer[] numbers5 = new Integer[] { 1, 1 };
    List<Integer> list5 = Arrays.asList(numbers5);
    listOfLists.add(new ArrayList<Integer>(list5));

      Integer[] numbers6 = new Integer[] { 2,3 };
    List<Integer> list6 = Arrays.asList(numbers6);
    listOfLists.add(new ArrayList<Integer>(list6));

      Integer[] numbers7 = new Integer[] { 1,5 };
    List<Integer> list7 = Arrays.asList(numbers7);
    listOfLists.add(new ArrayList<Integer>(list7));

      Integer[] numbers8 = new Integer[] { 1,5 };
    List<Integer> list8 = Arrays.asList(numbers8);
    listOfLists.add(new ArrayList<Integer>(list8));

        // ArrayList<Integer> innerList1 = new ArrayList<>();
        // innerList1.add(2);
        // innerList1.add(5);

        //  nnerList1.add(1);
        // innerList1.add(2);

        // ArrayList<Integer> innerList2 = new ArrayList<>();
        // innerList2.add(1);
        // innerList2.add(7);

        // innerList2.add(2);
        // innerList2.add(3);

        //   ArrayList<Integer> innerList3 = new ArrayList<>();
        // innerList3.add(2);
        // innerList3.add(9);

        // listOfLists.add(innerList1);
        // listOfLists.add(innerList2);
        // // listOfLists.add(innerList3);
        Treeset_1 mg = new Treeset_1();
         ArrayList<Integer> arry = mg.solve(A,listOfLists);
         for (int i : arry)
         {
        System.out.println(i);
         }
    }
}