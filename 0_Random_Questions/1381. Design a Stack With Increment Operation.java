class CustomStack {
    List<Integer> l;
    int max,size;
    public CustomStack(int maxSize) {
        l=new ArrayList<>();
        max=maxSize;
        size=0;
    }
    
    public void push(int x) {
        if(size<max){
            l.add(x);
            size++;
        }
    }
    
    public int pop() {
        if(size==0) return -1;
        int t=l.get(size-1);
        l.remove(size-1);
        size--;
        return t;
    }
    
    public void increment(int k, int val) {
        int i=0;
        while(i<k && i<size){
            l.set(i,l.get(i)+val);
            i++;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
