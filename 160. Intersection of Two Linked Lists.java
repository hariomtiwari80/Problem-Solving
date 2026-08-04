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
        ListNode temp1=headA,temp2=headB;
        int n1=0,n2=0;
        while(temp1!=null){
            n1++;
            temp1=temp1.next;
        }
        while(temp2!=null){
            n2++;
            temp2=temp2.next;
        }
        int diff=Math.abs(n1-n2);
        if(diff!=0){
            if(n1>n2){
                while(diff!=0){
                    headA=headA.next;
                    diff--;
                }
            }
            else{
                while(diff!=0){
                    headB=headB.next;
                    diff--;
                }
            }
        }
        while(headA!=null && headB!=null){
            if(headA==headB) return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}
