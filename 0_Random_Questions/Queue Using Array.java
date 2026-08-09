class myQueue {

    public int[] arr;
    public int front,rear;
    int size;
    public myQueue(int n) {
        arr=new int[n]; 
        front=-1;
        rear=-1;
        size=n;
    }

    public boolean isEmpty() {
        return front==-1;
    }

    public boolean isFull() {
        return rear==size-1;
    }

    public void enqueue(int x) {
        if(isFull()) return;
        if(isEmpty()){
            front=0;
            rear=0;
        }
        else{
            rear++;
        }
        arr[rear]=x;
    }

    public void dequeue() {
        if(isEmpty()) {
            return;
        }
        if(rear==0){
            front=-1;
            rear=-1;
        }
        else{
            while(front<rear){
                arr[front]=arr[front+1];
                front++;
            }
            front=0;
            rear--;
        }
    }

    public int getFront() {
        if(front==-1) return -1;
        return arr[front];
    }

    public int getRear() {
        if(rear==-1) return -1;
        return arr[rear];
    }
}
