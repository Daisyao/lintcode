
public class Solution160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int Alen = getlength(headA);
        int Blen = getlength(headB);
        if (Alen ==  0 || Blen == 0) {
        	return null;
        }
        if (Alen < Blen) {
        	while (Blen != Alen) {
        		headB = headB.next;
        		Blen--;
        	}
        } else if (Blen < Alen) {
        	while (Alen != Blen) {
        		headA = headA.next;
        		Alen--;
        	}
        }
        while (Alen != 0 ) {
        	if (headA == headB) {
        		return headA;
        	}
        	headA = headA.next;
        	headB = headB.next;
        }
        return null;
    }
	private int getlength(ListNode head) {
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		return len;
	}
}
