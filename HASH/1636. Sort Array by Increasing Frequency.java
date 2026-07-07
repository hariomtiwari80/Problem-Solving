class Solution {
    class pair{
        int a,b;
        pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    public int[] frequencySort(int[] arr) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        pair[] p=new pair[map.size()];
        int i=0;
        for(int key:map.keySet()){
            p[i++]=new pair(key,map.get(key));
        }
        Arrays.sort(p,(x, y)->{
            if(x.b==y.b)
                return y.a-x.a;
            return x.b-y.b;      
        });
        i=0;
        for(pair t:p) {
            for(int j=0;j<t.b;j++) {
                arr[i++]=t.a;
            }
        }
        return arr;
    }
}
