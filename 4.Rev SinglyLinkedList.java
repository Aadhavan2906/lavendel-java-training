import java.util.HashMap;

public class Main {
    
    class Solution {
    public ListNode reverseInGroups(ListNode head, int k) {
    if (head == null || head.next == null || k <= 1) {
        return head;
    }
    ListNode current = head;
    ListNode nextGroup = null;
    ListNode prev = null;
    int count = 0;
    while (current != null && count < k) {
        count++;
        ListNode next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    head.next = current;
    if (nextGroup != null) {
        nextGroup.reverseInGroups(current, k);
    }
    return prev;
}
    
}