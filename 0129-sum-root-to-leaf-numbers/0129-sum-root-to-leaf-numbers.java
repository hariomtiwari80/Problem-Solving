class Solution {
    public int SumRec(TreeNode root, int sum) {
        if(root == null) return 0;

        if(root.left == null && root.right == null) {
            sum = 10 * sum + root.val;
            return sum;
        }

        int leftSum = SumRec(root.left, 10 * sum + root.val);
        return leftSum + SumRec(root.right, 10 * sum + root.val);
    }

    public int sumNumbers(TreeNode root) {
        return SumRec(root, 0);
    }
}