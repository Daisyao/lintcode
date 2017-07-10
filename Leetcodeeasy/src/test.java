
public class test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Solution141 s = new Solution141();
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (int i = 1; i < 5; i++) {
        	temp.next = new ListNode(i);
        	temp = temp.next;
        }
        temp.next = head.next;
        ListNode result = s.hasCycle(head);
      //  s.rorate(digits, 7+3);
 //       int result = s.lengthOfLongestSubstringKDistinct(a, 3);
        System.out.println(result.val);
//        for (int i = 0; i < digits.length; i++) {
//            System.out.println(digits[i]);
//        }
    }

}
