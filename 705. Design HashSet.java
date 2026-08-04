class MyHashSet {
    public List<Integer> l;
    public MyHashSet() {
        l=new ArrayList<>();
    }
    
    public void add(int key) {
        boolean b=false;
        for(int i=0;i<l.size();i++){
            if(l.get(i)==key){
                b=true;
                break;
            }
        }
        if(!b) l.add(key);
    }
    
    public void remove(int key) {
        for(int i=0;i<l.size();i++){
            if(l.get(i)==key){
                l.remove(i);
                break;
            }
        }
    }
    
    public boolean contains(int key) {
        for(int i=0;i<l.size();i++){
            if(l.get(i)==key) return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
