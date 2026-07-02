class Solution {
    public int[] arrayChange(int[] arr, int[][] oper) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        for(int i=0;i<oper.length;i++){
            if(map.containsKey(oper[i][0])){
                arr[map.get(oper[i][0])]=oper[i][1];
                map.put(oper[i][1],map.get(oper[i][0]));
            }
        }
        return arr;
    }
}
