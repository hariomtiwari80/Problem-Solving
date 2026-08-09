class LRUCache {
    class Node{
        int key,value;
        Node next,prev;
        Node(int key,int value){
            this.key=key;
            this.value=value;
            next=prev=null;
        }
    }

    public HashMap<Integer,Node> map;
    public int cap;
    public Node head,tail;
    public LRUCache(int capacity) {
        map=new HashMap<>();
        cap=capacity;
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node=map.get(key);
        delete(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            delete(node);
            node.value=value;
            add(node);
        }
        else{
            Node node=new Node(key,value);
            add(node);
            map.put(key,node);
            if(cap!=0){
                cap--;
            }
            else{
                Node temp=tail.prev;
                delete(temp);
                map.remove(temp.key);
            }
        }
    }

    public void add(Node node){
        node.next=head.next;
        node.prev=head;

        head.next.prev=node;
        head.next=node;
    }
    public void delete(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
}
