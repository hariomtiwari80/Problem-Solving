import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(0, n, k, res, curr);
        return res;
    }

    private void backtrack(int pos, int n, int k,
                           List<List<Integer>> res,
                           List<Integer> curr) {

        if (curr.size() > k) return;

        if (pos == n) {
            if (curr.size() == k)
                res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(pos + 1);
        backtrack(pos + 1, n, k, res, curr);
        curr.remove(curr.size() - 1);

        backtrack(pos + 1, n, k, res, curr);
    }
}