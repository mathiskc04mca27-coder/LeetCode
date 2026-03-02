class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // A dummy head helps simplify the logic for creating the new list.
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        // Loop as long as there are digits in either list or a remaining carry.
        while (l1 != null || l2 != null || carry != 0) {
            // Get the values from the current nodes, or 0 if the list has ended.
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // Calculate sum and the new carry.
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            
            // Create a new node with the single digit (sum % 10).
            current.next = new ListNode(sum % 10);
            current = current.next;

            // Advance the input list pointers if they are not null.
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Return the next node after the dummy head.
        return dummyHead.next;
    }
}
