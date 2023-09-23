package DSA.JAVA2DArrays;

import java.util.*;



class IntervalComparator implements Comparator<Interval> {
  
    // override the compare() method
    public int compare(Interval s1, Interval s2)
    {
        if (s1.start < s2.start)
            return 1;
        else if (s1.start > s2.start)
            return 0;
        else
            return -1;
    }
}
public class AdvIntrxPrblms {
    public Interval[] mergeList(Interval[] intervals) {
        
        // int[] numbers = {4, 9, 1, 3, 2, 8, 7, 0, 6, 5};

        // System.out.println(Arrays.toString(numbers));

        // java.util.Arrays.sort(numbers);

        // System.out.println(Arrays.toString(numbers));

        //   for(int i = 0; i < intervals.length; i++) {
        //     System.out.println("Before sorting: " + intervals[i].start + " " + intervals[i].end);
        // }

        Arrays.sort(intervals);
       
        int start = intervals[0].start;
        int end = intervals[0].end;
        List<Interval> mergedList = new ArrayList<Interval>();
         Interval intl1 =  new Interval(start, end);
         mergedList.add( intl1);
        int count = 0;

        for(int i = 1; i < intervals.length; i++) {
            if (intervals[i].start <= end) {
                end = getMax(end,  intervals[i].end);
                start = getMin(start,  intervals[i].start);
                Interval intl =  mergedList.get(count);
                intl.end = end;
                intl.start = start;
                mergedList.set(count, intl);
            } else {
                Interval mergedInterval = new Interval(start, end);
                 count += 1;
                 mergedList.add(mergedInterval);
                start = intervals[i].start;
                end = intervals[i].end;
            }
        }
        Interval[] result = mergedList.toArray(new Interval[mergedList.size()]);

        return result;
    }

     public int getMax(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }

     public int getMin(int a, int b) {
        if (a <= b) {
            return a;
        } else {
            return b;
        }
    }

      public Interval[] mergeListWith2DArray(int[][] intervals) {
        
        int start = intervals[0][0];
        int end = intervals[0][0];
        List<int[]> mergedList = new ArrayList<int[]>();
        mergedList.add(intervals[0]);
        int count = 0;

        for(int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = getMax(end,  intervals[i][1]);
                end =  intervals[i][1];
                start = getMin(start,   intervals[i][0]);
                int[] intl =  mergedList.get(count);
                intl[0] = end;
                intl[1] = start;
                mergedList.set(count, intl);
            } else {
                int[] mergedInterval = {start, end};
                 count += 1;
                 mergedList.add(mergedInterval);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        Interval[] result = mergedList.toArray(new Interval[mergedList.size()]);

        return result;
    }

   

    public static void main(String[] args) {
        // A : [ (1, 10), (2, 9), (3, 8), (4, 7), (5, 6), (6, 6) ]
        // A : [ (1, 10), (2, 9), (3, 8), (4, 7), (5, 6), (6, 6) ]
        // 1 6

        // A : [ (1, 10), (2, 9), (3, 8), (4, 7), (5, 6), (6, 6) ]

         Interval[] arrayInt = new Interval[] { new Interval(1, 10)
        , new Interval(2, 9), new Interval(3, 8), new Interval(4, 7),  new Interval(5, 6), new Interval(6, 6)};

        // Interval[] arrayInt = new Interval[] { new Interval(30, 63)
        // , new Interval(66, 94), new Interval(36, 87), new Interval(16, 86), new Interval(26, 85), new Interval(24, 50), new Interval(17, 84), new Interval(5, 25), 
        // new Interval(67, 81), new Interval(23, 54), new Interval(84, 99), new Interval(48, 85), new Interval(23, 28), new Interval(3, 86), new Interval(63, 79), new Interval(18, 73), new Interval(6, 68), 
        // new Interval(34, 40), new Interval(61, 66), new Interval(60, 96), new Interval(95, 99), new Interval(1, 10), new Interval(4, 82), new Interval(19, 78), new Interval(23, 61), new Interval(30, 45), new Interval(53, 87),
        //  new Interval(10, 42), new Interval(80, 93), new Interval(33, 73), new Interval(64, 65), new Interval(29, 71), new Interval(73, 89), new Interval(2, 98), new Interval(62, 67), new Interval(84, 98), new Interval(43, 58), 
        //  new Interval(20, 45), new Interval(86, 92), new Interval(22, 100), new Interval(72, 74), new Interval(5, 52), new Interval(48, 56), new Interval(69, 93), new Interval(8, 98), new Interval(37, 47), 
        //  new Interval(19, 45), new Interval(22, 99), new Interval(34, 97), new Interval(21, 80), new Interval(58, 77), new Interval(48, 66), new Interval(59, 91), new Interval(18, 33), new Interval(2, 7), new Interval(8, 92), new Interval(12, 32), new Interval(17, 83), 
        //  new Interval(11, 16), new Interval(60, 75), new Interval(9, 11), new Interval(3, 61), new Interval(4, 18), new Interval(53, 68), new Interval(17, 39), new Interval(18, 93), new Interval(15, 55), new Interval(4, 34), new Interval(48, 85), new Interval(61, 65), 
        //  new Interval(59, 77), new Interval(15, 37), new Interval(62, 82), new Interval(4, 78), new Interval(80, 96), new Interval(4, 42), new Interval(15, 48), new Interval(27, 45) };
        // Interval[] arrayInt = new Interval[6];

        // Interval interval = new Interval(30, 63);
        // arrayInt[0]= interval;

        //  Interval interval2 = new Interval(64, 94);
        // arrayInt[1]= interval2;
        //  Interval interval3 = new Interval(3, 88);
        // arrayInt[2]= interval3;
        //  Interval interval4 = new Interval(4, 7);
        // arrayInt[3]= interval4;
        //  Interval interval5 = new Interval(5, 6);
        // arrayInt[4]= interval5;
        //  Interval interval6 = new Interval(-100, 31);
        // arrayInt[5]= interval6;
        AdvIntrxPrblms obj1 = new AdvIntrxPrblms();

        Interval[] arry = obj1.mergeList(arrayInt);
        
        for(int i = 0; i < arry.length; i++) {
        System.out.println(arry[i].start + " and  " + arry[i].end);
        }
    }
}
