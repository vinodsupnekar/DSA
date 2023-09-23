
package JAVALinkedLists;

 
public class Solution {

 static ListNode solve(ListNode A, int B, int C) {
        ListNode head = A;
        ListNode newNode = new ListNode(B);
        int count = 1;
        C = C + 1;
        if (C == 1 || A.next == null) {
            ListNode temp = A;
            A = newNode;
            newNode.next = temp;
            return head;
        }
        while((A.next != null) && (count < (C - 1))) {

            A = A.next;
            count = count + 1;
        }
        ListNode tempNode = A.next;
        A.next = newNode;
        newNode.next = tempNode;
        return head;
    }

    static ListNode insertNode(ListNode A, int B, int C){
        ListNode head = A;
        ListNode newNode = new ListNode(B);
        var count = 1;
//        C += 1;
        if (C == 1 || A.next == null ) {
            var temp = A.next;
            A = newNode;
            newNode.next = temp;
            return head;
        }

        while (count <= (C - 1) && (A.next != null)) {
            A = A.next;
            count += 1;
        }

        var temp = A.next;
        A.next = newNode;
        newNode.next = temp;
        return head;
    }


	public static void main(String[] args) {
        System.out.println("my first java code");
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        ListNode A = a;
        ListNode head = Solution.insertNode( A, 3, 3);

        while (head != null) {
            System.out.println(head.val + " ");
            head = head.next;
        }

    }
}
