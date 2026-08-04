class MinStack {
    public Stack<Integer> st;
    public Stack<Integer> minst;
    public MinStack() {
        st=new Stack<>();
        minst=new Stack<>();
    }
    
    public void push(int value) {
        st.push(value);
        if(minst.size()==0 || value<=minst.peek()) minst.push(value);
    }
    
    public void pop() {
        int val=st.pop();
        if(minst.size()!=0 && minst.peek()==val) minst.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minst.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
