package DSA.JAVA2DArrays;

public class Interval{  //implements Comparable<Interval>}{
     int start =0;
    int end = 0;
    public int getstart() { return start; }
    public int getend() { return end; }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // @Override
    // public int compareTo(Interval o)
    // {
    //     if (this.start > o.start) {
    //         return 1;
    //     } else if (this.start == o.start) {
    //         return 0;
    //     } else if (this.start < o.start) {
    //         return -1;
    //     } 
    //     return -1;
    // }
}
