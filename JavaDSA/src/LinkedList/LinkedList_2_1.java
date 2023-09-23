package LinkedList;

// public class LinkedList_2_1 {
    
// }

/**
 * Definition for singly-linked list.
 * 
 */
class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
public class LinkedList_2_1 {

    public ListNode getMid(ListNode A){
        ListNode slow = A;
        ListNode fast = A;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode sortList(ListNode A) {
        if(A == null || A.next == null){
            return A;
        }
        ListNode mid = getMid(A);
        ListNode headLeft = A;
        ListNode headRight = mid.next;
        mid.next = null;
         sortList(headLeft);
         sortList(headRight);
         return mergeList(headLeft, headRight);
    }

    public ListNode mergeList(ListNode A, ListNode B){
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        ListNode tail = dummy;
        ListNode headA = A;
        ListNode headB = B;
        ListNode tailA = A;
        ListNode tailB = B;

        if(headA != null && headB!= null) {
            if(headA.val <= headB.val) {
                head = headA;
                tail = headA;
                tailA = headA.next;
            } else {
                head = headB;
                tail = headB;
                tailB = headB.next;
            }
            while(tailA != null && tailB != null){
                if(tailA.val <= tailB.val){
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
        int[] numbers =  {4,22,11,22,66,100,60,50,40,30,20};//{5,66,68,42,73,25,84,63,72,20,77,38,8,99,92,49,74,45,30,51,50,95,56,19,31,26,98,67,100,2,24,6,37,69,11,16,61,23,78,27,64,87,3,85,55,22,33,62};
        // int[] numbersB = {4,6,8};
        Node headA = new Node(numbers[0]);
        Node tempA = headA;
        for(int i=1; i< numbers.length; i++){
              Node node1 = new Node(numbers[i]);
            tempA.next = node1;
            tempA = node1;
        }
        LinkedList_2 obj = new LinkedList_2();
        Node c =  obj.sortList(headA);//obj.mergeList(headA, headB);
        Node k = c;
        while(k!= null){
        System.out.println(k.value);
        k = k.next;
        }
    }
}

