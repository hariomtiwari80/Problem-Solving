class MyCircularQueue {
    public int[] arr;
    public int first,last,size;
    public MyCircularQueue(int k) {
        arr=new int[k];
        first=-1;
        last=-1;
        size=0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false; 
        if(first==-1 && last==-1){
            first=0;
            last=0;
            arr[0]=value;
        }
        else{
            last=(last+1)%arr.length;
            arr[last]=value;
        }
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        if(first==last){
            first=-1;
            last=-1;
        }
        else if(first<last){
            first++;
        }
        else{
            if(first==arr.length-1) first=0;
            else first++;
        }
        size--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return arr[first];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return arr[last];
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==arr.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
