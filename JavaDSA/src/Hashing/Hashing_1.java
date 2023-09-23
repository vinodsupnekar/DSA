package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Searching.TwoPointers;

import java.util.Iterator;

public class Hashing_1 {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestConsecutive(final List<Integer> A) {
        
        int ans = Integer.MIN_VALUE;
        Integer y = 0;
        int chain = 0;

        HashMap<Integer,Integer> hashMap=new HashMap<Integer,Integer>();
        for(int i = 0; i < A.size(); i++) {
            hashMap.put(i, A.get(i));
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = iterator.next(); 
             int value = entry.getValue();
             boolean isValuePresent = hashMap.containsValue(value-1);
            if(!isValuePresent) {
                chain = 1;
                y = value+1;
                while(hashMap.containsValue(y)) {
                    chain++;
                    y++;
                }
                ans = Math.max(ans, chain);
            }
        }
        return ans;
    }

     public static void main(String[] args) {
        Hashing_1 hashing = new Hashing_1();
         int[] A = {2,1, 0, 116960, 162402, 884901, 257140, 900943, 873835, 366084, 18817, 46652, 163111};
         List<Integer> arr = new ArrayList<Integer>(A.length);

        for (int i : A)
        {
            arr.add(i);
        }
        int aa = hashing.longestConsecutive(arr);
        System.out.println(aa);
    }

}



