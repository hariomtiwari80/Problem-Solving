class MyCircularQueue {
    public int[] arr;
    public int front,rear,cap;
    public MyCircularQueue(int k) {
        arr=new int[k];
        front=-1;
        rear=-1;
        cap=k;
    }
    
    public boolean enQueue(int val) {
        if(isFull()) return false;
        arr[(rear+1)%cap]=val;
        rear=(rear+1)%cap;
        if(front==-1) front=0;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        if(front==rear){
            front=-1;
            rear=-1;
        }
        else{
            front=(front+1)%cap;
        }
        return true;
    }
    
    public int Front() {
        if(front==-1) return -1;
        return arr[front];
    }
    
    public int Rear() {
        if(rear==-1) return -1;
        return arr[rear];
    }
    
    public boolean isEmpty() {
        return front==-1;
    }
    
    public boolean isFull() {
        return (rear+1)%cap==front;
    }
}
