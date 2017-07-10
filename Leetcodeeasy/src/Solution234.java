
public class Solution234 {
	public boolean isPalindrome(ListNode head) {
		ListNode tailHead = null;
		tailHead = reverseList(head, tailHead);
		ListNode node1 = head;
		ListNode node2 = tailHead;
		while (node1 != null) {
			if (node1.val != node2.val) {
				return false;
			}
			node1 = node1.next;
			node2 = node2.next;
		}
		
		return true;
	}
	private ListNode reverseList(ListNode node, ListNode newHead) {
		if (node == null) return newHead;
		ListNode newNode = new ListNode(node.val);
		ListNode next = node.next;
		newNode.next = newHead;
		newHead = newNode;
		return reverseList(next, newHead);
	}
}
