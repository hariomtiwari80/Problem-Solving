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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=null;
        while(slow!=null){
            ListNode t=slow.next;
            slow.next=temp;
            temp=slow;
            slow=t;
        }
        while(temp!=null){
            if(temp.val!=head.val) return false;
            head=head.next;
            temp=temp.next;
        }
        return true;
    }
}
