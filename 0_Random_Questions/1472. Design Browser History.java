class BrowserHistory {
    class Node{
        String val;
        Node next,prev;
        Node(String val){
            this.val=val;
            next=prev=null;
        }
    }
    public Node temp;
    public BrowserHistory(String s) {
        temp=new Node(s);
    }
    
    public void visit(String url) {
        Node node=new Node(url);
        node.prev=temp;
        temp.next=node;
        temp=node;
    }
    
    public String back(int steps) {
       while(steps!=0 && temp.prev!=null){
        temp=temp.prev;
        steps--;
       } 
       return temp.val;
    }  
    
    public String forward(int steps) {
        while(steps!=0 && temp.next!=null){
            temp=temp.next;
            steps--;
        }
        return temp.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
