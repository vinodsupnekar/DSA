package LinkedList;

import java.lang.reflect.Array;

import Hashing_2.Hashing_2;

class Node {
    int value;
    Node next;
    Node(int x) {
        this.value = x;
    }
}

public class LinkedList_2 {

    public Node getMid(Node A){
        Node slow = A;
        Node fast = A;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node sortList(Node A){
        if(A == null || A.next == null){
            return A;
        }
        Node mid = getMid(A);
        Node headLeft = A;
        Node headRight = mid.next;
        mid.next = null;
        Node left = sortList(headLeft);
        Node right = sortList(headRight);
         return mergeList(left, right);
    }

    public Node mergeList(Node A, Node B){
        Node dummy = new Node(-1);
        Node head = dummy;
        Node tail = dummy;
        Node headA = A;
        Node headB = B;
        Node tailA = A;
        Node tailB = B;

        if(headA != null && headB!= null) {
            if(headA.value <= headB.value) {
                head = headA;
                tail = headA;
                tailA = headA.next;
            } else {
                head = headB;
                tail = headB;
                tailB = headB.next;
            }
            while(tailA != null && tailB != null){
                if(tailA.value <= tailB.value){
                    tail.next = tailA;
                    tail = tailA;
                    tailA = tailA.next;
                } else {
                    tail.next = tailB;
                    tail = tailB;
                    tailB = tailB.next;
                }
            }
            if(tailA == null){
                tail.next = tailB;
            } else  if(tailB == null){
                 tail.next = tailA;
            }
        }
        return head;
    }

     public static void main(String[] args) {
        // int[] a = {1,3,5,7};
        // int[] b = {2,4,6,8};
        int[] numbers = {5,66,68,42,73,25,84,63,72,20,77,38,8,99,92,49,74,45,30,51,50,95,56,19,31,26,98,67,100,2,24,6,37,69,11,16,61,23,78,27,64,87,3,85,55,22,33,62};
        // int[] numbersB = {4,6,8};
        Node headA = new Node(numbers[0]);
        // Node headB = new Node(numbersB[0]);
        Node tempA = headA;
        //   Node tempB = headB;
        for(int i=1; i< numbers.length; i++){
              Node node1 = new Node(numbers[i]);
            // Node node2 = new Node(numbersB[i]);
            tempA.next = node1;
            // tempB.next = node2;
            tempA = node1;
            // tempB = node2;
        }
        // Node bb = headB;
        // while(bb!= null) {
        //       System.out.println(bb.value);
        //       bb = bb.next;
        // }
        LinkedList_2 obj = new LinkedList_2();
        Node c =  obj.sortList(headA);//obj.mergeList(headA, headB);
        Node k = c;
        while(k!= null){
        System.out.println(k.value);
        k = k.next;
        }
    }

    
}
