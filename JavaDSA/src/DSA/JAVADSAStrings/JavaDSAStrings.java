package DSA.JAVADSAStrings;

public class JavaDSAStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println("Hello World");
		 JavaDSAStrings obj = new JavaDSAStrings();
		 int anagram = obj.solve("abcdq", "bcadk");
		 System.out.println("is anagram ==>" + anagram);

	}

    public int solve(String A, String B) {
        String str = B;
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            str = findReplaceInStr(str, ch);
        }
        if (str.length() == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public String findReplaceInStr(String s1, char c) {
       int index =  s1.indexOf(c);
        StringBuilder newStr = new StringBuilder(s1);
        if (index >= 0 && index < newStr.length()) {
            newStr.deleteCharAt(index);
        }
        return newStr.toString();
    }
}


