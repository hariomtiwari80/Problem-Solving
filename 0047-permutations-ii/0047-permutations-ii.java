class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); 
        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    void backtrack(List<List<Integer>> res, List<Integer> templist, int[] nums, boolean[] used) {
        if (templist.size() == nums.length) {
            res.add(new ArrayList<>(templist));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; 
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            templist.add(nums[i]);
            used[i] = true;
            backtrack(res, templist, nums, used);
            templist.remove(templist.size() - 1); 
            used[i] = false;
        }
    }
}