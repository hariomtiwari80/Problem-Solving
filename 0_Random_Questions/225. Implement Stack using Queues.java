class MyStack {
    public Deque<Integer> dq;
    public MyStack() {
        dq=new ArrayDeque<>();
    }
    
    public void push(int x) {
        dq.addLast(x);
        int n=dq.size();
        for(int i=0;i<n-1;i++){
            dq.addLast(dq.removeFirst());
        }
    }
    
    public int pop() {
        return dq.removeFirst();
    }
    
    public int top() {
        return dq.getFirst();
    }
    
    public boolean empty() {
        return dq.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
