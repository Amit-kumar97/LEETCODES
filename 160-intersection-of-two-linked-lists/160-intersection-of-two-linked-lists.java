/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode cur1=headA;
        ListNode cur2=headB;
        int count1=0;
        int count2=0;
        
        while(cur1!=null)
        {
            count1++;
            cur1=cur1.next;
        }
        while(cur2!=null)
        {
            count2++;
            cur2=cur2.next;
        }
        cur1=headA;
        cur2=headB;
        if(count1>count2){
            int diff = count1-count2;
            for(int j=0;j<diff;j++){
                cur1=cur1.next;
            }
        }
        else {
            int diff = count2-count1;
            for(int j=0;j<diff;j++){
                cur2=cur2.next;
            }
        }
        while(cur1!=null && cur2!=null){
            if(cur1==cur2){
                return cur1;
            }
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return null;
    }
}