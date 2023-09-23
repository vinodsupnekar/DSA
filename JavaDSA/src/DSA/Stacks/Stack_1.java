package DSA.Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Stack_1  {
    public int solve(String A) {

     final Map<Character, Character> mirrorCharMap = new HashMap<>();
        mirrorCharMap.put('}', '{'); // A remains the same in a mirror image
        mirrorCharMap.put(']', '['); // Example mirror image for B
        mirrorCharMap.put(')', '('); // Example mirror image for C
        // Add more mappings as needed

        Stack stack = new Stack();
        for (int i = 0; i < A.length(); i++) { 
            char ch = A.charAt(i);
            if(ch == '{' || ch == '(' || ch == '['){
                stack.push(ch);
            }
            else {
                if(stack.isEmpty() == true){
                    return 0;
                } else if( stack.top() != mirrorCharMap.get(ch)) {
                    return 0;
                } else {
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty() == true) {
            return 1;
        }
        return 0;
    }

     public static void main(String[] args) {
        // int[] a = {1,3,5,7};
        // int[] b = {2,4,6,8};
        // Stack_1 stk = new Stack_1();
        // int kk = stk.solve("{([])}"); 
        // System.out.println(kk);

        
         EvaluatePostFix evl = new EvaluatePostFix();
         String[] arry1 = new String[]{"4", "2", "/"};
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList(arry1));  
        int kk = evl.evalRPN(list1); 
        System.out.println(kk);
    }
}

class Node {
    char data;
    Node next;

    public Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    private Node tos;

    public Stack() {
        this.tos = null;
    }

    public void push(char data) {
        Node newNode = new Node(data);
        if(tos == null) {
            tos = newNode;
        } else {
            newNode.next = tos;
            tos = newNode;
        }
    }

    public char pop() {
        if (tos == null) {
            throw new IllegalStateException("Stack is empty");
        }

        char data = tos.data;
        tos = tos.next;
        return data;
    }

    public char top() {
        if (tos == null) {
            throw new IllegalStateException("Stack is empty");
        }

        char data = tos.data;
        return data;
    }

    public boolean isEmpty() {
        return tos == null;
    }
}


 class EvaluatePostFix {
    public int evalRPN(ArrayList<String> A) {
         Stack stack = new Stack();

        for(int i = 0; i< A.size(); i++){
            String str = A.get(i);
            if(isOperator(str) == true) {
                int operator1 = stack.pop();
                int operator2 = stack.pop();
                int res = evaluate(operator1, operator2, str);
                stack.push(res);
            } else {
                stack.push( Integer.parseInt(str));
            }
        }
        return  stack.top();
    }

    public boolean isOperator(String str) {
        if (str == "+" || str == "-" || str == "*" || str == "/"){
            return true;
        } 
        return false;
    }

    public int evaluate(int operator1, int operator2, String operator){
        if(operator == "+"){
            return operator1+operator2;
        } else if(operator == "-"){
            return operator1-operator2;
        }  else if(operator == "*"){
            return operator1*operator2;
        } else if (operator == "/"){
            return operator1/operator2;
        }
        return 0;
    }


class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    private Node tos;

    public Stack() {
        this.tos = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if(tos == null) {
            tos = newNode;
        } else {
            newNode.next = tos;
            tos = newNode;
        }
    }

    public int pop() {
        if (tos == null) {
            throw new IllegalStateException("Stack is empty");
        }

        int data = tos.data;
        tos = tos.next;
        return data;
    }

    public int top() {
        if (tos == null) {
            throw new IllegalStateException("Stack is empty");
        }

        int data = tos.data;
        return data;
    }

    public boolean isEmpty() {
        return tos == null;
    }
}
}




