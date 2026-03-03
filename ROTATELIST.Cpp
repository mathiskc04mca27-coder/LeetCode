/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        // 1. Edge cases: empty list, single node, or no rotation needed
        if (!head || !head->next || k == 0) {
            return head;
        }

        // 2. Compute the length of the list and find the tail
        ListNode* last_node = head;
        int length = 1;
        while (last_node->next) {
            last_node = last_node->next;
            length++;
        }

        // 3. Optimize k
        k = k % length;
        if (k == 0) {
            return head;
        }

        // 4. Connect tail to head to make it circular
        last_node->next = head;

        // 5. Find the new tail: (length - k - 1) steps from the current head
        int steps_to_new_tail = length - k - 1;
        ListNode* new_tail = head;
        for (int i = 0; i < steps_to_new_tail; i++) {
            new_tail = new_tail->next;
        }

        // 6. Break the circle
        ListNode* new_head = new_tail->next;
        new_tail->next = nullptr;

        return new_head;
    }
};
