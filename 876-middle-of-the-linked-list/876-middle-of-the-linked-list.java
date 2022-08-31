/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        
        ListNode temp = head;
        int n = 0;
        while(temp!=null)
        {
            n++;
            temp = temp.next;
        }
            
        temp = head;
        for(int i=0; i<n/2; i++)
            temp = temp.next;
        return temp;
    }
}