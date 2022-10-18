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
    public ListNode mergeKLists(ListNode[] lists) {
        return helper(lists, 0, lists.length-1);
    }
    
    private ListNode helper(ListNode[] lists, int l, int r) {
        if(r<l) 
            return null;
        if(r==l) 
            return lists[r];
        
        int mid = (l+r)/2;
        ListNode a = helper(lists, l, mid);
        ListNode b = helper(lists, mid + 1, r);
        ListNode dmHead = new ListNode(0);
        ListNode cur = dmHead;
        while(a!=null && b!=null) {
            if (a.val<b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        cur.next = (a!=null) ? a : b;
        
        return dmHead.next;
    }
}