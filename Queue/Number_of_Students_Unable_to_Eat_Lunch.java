class Solution {
    public int countStudents(int[] stud, int[] sand) {
        int n=stud.length;
        Queue<Integer> q=new LinkedList<>();
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            st.push(sand[i]);
        }
        for(int i=0;i<n;i++){
            q.add(stud[i]);
        }
        while(!st.isEmpty()){
            boolean b=false;
            for(int i=0;i<q.size();i++){
                if(st.peek()==q.peek()){
                    b=true;
                    break;
                }
                q.add(q.remove());
            }
            if(!b) return q.size();
            q.remove();
            st.pop();
        }
        return 0;
    }
}
