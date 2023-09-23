package Hashing_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hashing_2 {

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Set<String> pointSet = new HashSet<>();
        Set<String> visistedRectangles = new HashSet<>();
        for(int i=0; i<A.size(); i++){
            String s = A.get(i)+"-"+B.get(i);
            pointSet.add(s);
        }
        int N = A.size();
        for(int i=0; i<N; i++){
            int x1 = A.get(i);
            int y1 = B.get(i);
            for(int j=0; j<N; j++){
                if (i != j) {
                    int x2 = A.get(j);
                    int y2 = B.get(j);
                    if(x1!=x2 && y1!=y2){
                        String pointToSearch1 = x1+"-"+y2;
                        String pointToSearch2 = x2+"-"+y1;
                        if(pointSet.contains(pointToSearch1) && pointSet.contains(pointToSearch2)) {
                             String visitedRectangles = pointToSearch1 + pointToSearch2 +","+x1+"-"+y1 + x2+"-"+y2;
                             if (!visistedRectangles.contains(visitedRectangles)){
                                visistedRectangles.add(visitedRectangles);
                             }  
                        }
                    }
                }
            }
        }
        return visistedRectangles.size();
    }

    public void frequencyGenerator(String input, int[] frequencyArray) {
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                frequencyArray[c - 'A']++;
            } else if (Character.isLowerCase(c)) {
                frequencyArray[c - 'a' + 26]++;
            } else if (Character.isDigit(c)) {
                frequencyArray[c - '0' + 52]++;
            }
        }
    }

    public void increaseFrequency(char c, int[] array) {
         if (Character.isUpperCase(c)) {
                array[c - 'A']++;
            } else if (Character.isLowerCase(c)) {
                array[c - 'a' + 26]++;
            } else if (Character.isDigit(c)) {
                array[c - '0' + 52]++;
            }
    }

     public void decreaseFrequency(char c, int[] array) {
         if (Character.isUpperCase(c)) {
                array[c - 'A']--;
            } else if (Character.isLowerCase(c)) {
                array[c - 'a' + 26]--;
            } else if (Character.isDigit(c)) {
                array[c - '0' + 52]--;
            }
    }

    //  public void frequencyGeneratorPaddedWithCapital_A(String input, int[] frequencyArray) {
    //     for (char c : input.toCharArray()) {
    //         // if (Character.isUpperCase(c)) {
    //             frequencyArray[c - 'A']++;
    //         // } 
    //         // else if (Character.isLowerCase(c)) {
    //         //     frequencyArray[c - 'a' + 26]++;
    //         // } else if (Character.isDigit(c)) {
    //         //     frequencyArray[c - '0' + 52]++;
    //         // }
    //     }
    // }
        public String minWindow(String A, String B) {
            int[] fA = new int[62];
            int[] fB = new int[62];
            int l = 0;
            int r = B.length()-1;
            String ans = "";
            // frequencyGenerator(A, fA);
            // frequencyGenerator(B, fB);
            // frequencyGeneratorPaddedWithCapital_A(C, fC);

            for(int i=0; i< B.length(); i++){
                char c = B.charAt(i);
                // fB[a-'a']++
                 if (Character.isUpperCase(c)) {
                    fB[c - 'A']++;
                } else if (Character.isLowerCase(c)) {
                    fB[c - 'a' + 26]++;
                } else if (Character.isDigit(c)) {
                    fB[c - '0' + 52]++;
                }
            }

            if(B.length() > A.length()){
                return "";
            }

            for(int i=0; i< B.length(); i++){
                char c = A.charAt(i);
                // fA[a-'a']++;
                 if (Character.isUpperCase(c)) {
                    fA[c - 'A']++;
                } else if (Character.isLowerCase(c)) {
                    fA[c - 'a' + 26]++;
                } else if (Character.isDigit(c)) {
                    fA[c - '0' + 52]++;
                }
            }
            while(r< A.length()) {
                if(compare(fA,fB) == true) {
                    ans = A.substring(l, r+1);
                    decreaseFrequency(A.charAt(l), fA);
                    l++;
                } else {
                    r++;
                    if(r == A.length()) {
                        break;
                    }
                     increaseFrequency(A.charAt(r), fA);
                }
            }
            return ans;
        }
    
        boolean compare(int[] fA, int[] fB) {
            for(int i = 0; i<52; i++){
                if(fB[i] > fA[i]){
                    return false;
                }
            }
            return true;
        }
    

    public static void main(String[] args) {
        Hashing_2 hashing = new Hashing_2();
        
        // Integer[] numbers1 = new Integer[] {1, 1, 2, 2 };
        // List<Integer> list1 = Arrays.asList(numbers1);

        // Integer[] numbers2 = new Integer[] { 1, 2, 1, 2 };
        // List<Integer> list2 = Arrays.asList(numbers2);
        // int aa = hashing.solve(new ArrayList<Integer>(list1), new ArrayList<Integer>(list2));
        // System.out.println(aa);

        String A = "rGusddQS6UvK9GzxPSJDMSyoTOpkLK18ZfxKF64HwZ0";
        String B = "o8athbAkGyGg7B79xJzPZAXmnqw1dWlUMmA3LehdRaXl2S7HVrgmpUvj9m2RtnZggXG9B";
        String output = hashing.minWindow(A, B);
        System.out.println(output);
    }
    
}

        // String str = "abc"; B
        // String str2 = "k-0 b-1 c-2 a-3 k-4"; A
        // fA[] = [1 1 1 0 0...0.]; l = 1
        // fB[] = [1 1 1 0 0....]; r = 3
        // r = 2