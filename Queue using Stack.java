class myQueue {
    Stack<Integer> st=new Stack<>();

    void enqueue(int x) {
        Stack<Integer> t=new Stack<>();
        while(!st.isEmpty()){
            t.push(st.pop());
        }
        st.push(x);
        while(!t.isEmpty()){
            st.push(t.pop());
        }
    }

    void dequeue() {
        st.pop();
    }

    int front() {
        if(st.size()==0) return -1;
        return st.peek();
    }

    int size() {
        return st.size();
    }
}
