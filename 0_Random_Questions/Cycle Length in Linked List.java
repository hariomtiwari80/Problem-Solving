/* Structure of Linked List Node
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}*/

class Solution {
    public int lengthOfLoop(Node head) {
        if(head==null || head.next==null) return 0;
        Node slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) break;
        }
        if(slow!=fast) return 0;
        Node temp=head;
        while(slow!=temp){
            slow=slow.next;
            temp=temp.next;
        }
        int c=1;
        slow=slow.next;
        while(slow!=temp){
            c++;
            slow=slow.next;
        }
        return c;
        
    }
}
