class MyHashMap {
    class pair{
        int k,v;
        pair(int k,int v){
            this.k=k;
            this.v=v;
        } 
    }
    public List<pair> l;
    public MyHashMap() {
        l=new ArrayList<>();
    }
    
    public void put(int key, int value) {
        int idx=-1;
        for(int i=0;i<l.size();i++){
            if(l.get(i).k==key){
                idx=i;
                break;
            }
        }
        if(idx!=-1){
            l.remove(idx);
        }
        l.add(new pair(key,value));
        
    }
    
    public int get(int key) {
        for(int i=0;i<l.size();i++){
            if(l.get(i).k==key) return l.get(i).v;
        }
        return -1;
    }
    
    public void remove(int key) {
        for(int i=0;i<l.size();i++){
            if(l.get(i).k==key){
                l.remove(i);
                break;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
