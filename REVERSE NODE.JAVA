class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy, nex = dummy, prev = dummy;
        
        
        int count = 0;
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }

        
        while (count >= k) {
            curr = prev.next; // First node of the group
            nex = curr.next;  // Second node of the group
            
            
          for (int i = 1; i < k; i++) {
                curr.next = nex.next;
                nex.next = prev.next;
                prev.next = nex;
                nex = curr.next;
            }
            
            prev = curr; 
            count -= k;
        }
        
        return dummy.next;
    }
}
