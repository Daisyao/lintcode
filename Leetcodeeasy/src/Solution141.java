
public class Solution141 {
	public ListNode hasCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode walker = head;
		ListNode runner = head;
		while (runner.next != null && runner.next.next != null) {
			
			walker = walker.next;
			runner = runner.next.next;
			if (runner == walker) {
				walker = walker.next;
                while (true) {
                    if (walker == head) {
                        return head;
                    }
                    if (walker == runner){
                        head = head.next;
                    }
                    walker = walker.next;
                }
			}
		}
		return null;
	}
}
