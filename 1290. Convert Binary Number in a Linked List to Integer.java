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
    public int getDecimalValue(ListNode head) {
        List<Integer> l=new ArrayList<>();
        while(head!=null){
            l.add(head.val);
            head=head.next;
        }
        int n=1,ans=0;
        for(int i=l.size()-1;i>=0;i--){
            if(l.get(i)==1) ans+=n;
            n*=2;
        }
        return ans;
    }
}
