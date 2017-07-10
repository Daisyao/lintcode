

public class Solution206 {
   public ListNode reverseList(ListNode head) {
       /*
       Stack<Integer> theStack = new Stack<Integer>();
       ListNode temp = head;
       while (temp != null) {
           theStack.push(temp.val);
           temp = temp.next;
       }
       if (theStack.isEmpty()) {
           return head;
       }
       ListNode newHead = new ListNode(theStack.pop());
       temp = newHead;
       while (!theStack.isEmpty()) {
           temp.next = new ListNode(theStack.pop());
           temp = temp.next;
       }
       temp.next = null;
       return newHead;
       */
       //iterative
       /*
       ListNode newHead = null;
       ListNode temp = head;
       while (temp != null) {
           ListNode next = temp.next;
           temp.next = newHead;
           newHead = temp;
           temp = next;
       }
       return newHead;
       */
       //recursively
       ListNode newHead = null;
       return reverserecursive(head, newHead);
   }
   public ListNode reverserecursive(ListNode temp, ListNode newHead) {
       if (temp == null) {
           return newHead;
       }
       ListNode next = temp.next;
       temp.next = newHead;
       newHead = temp;
       temp = next;
       return reverserecursive(temp, newHead);
   }
   
}