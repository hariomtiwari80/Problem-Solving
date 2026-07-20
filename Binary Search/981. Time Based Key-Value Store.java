class TimeMap {
    class Pair{
        String val;
        int time;
        Pair(String val,int time){
            this.val=val;
            this.time=time;
        }
    }
    public HashMap<String,List<Pair>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            map.get(key).add(new Pair(value,timestamp));
        }
        else{
            List<Pair> p=new ArrayList<>();
            p.add(new Pair(value,timestamp));
            map.put(key,p);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair> p=map.get(key);
        int l=0,h=p.size();
        while(l<h){
            int m=l+(h-l)/2;
            if(p.get(m).time>timestamp) h=m;
            else l=m+1;
        }
        System.out.println(l);
        if(l-1<0) return "";
        return p.get(l-1).val;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
