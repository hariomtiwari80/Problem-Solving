class Solution {
    void inorder(TreeNode node, List<TreeNode> arr) {
        if (node == null) return;

        inorder(node.left, arr);
        arr.add(node);
        inorder(node.right, arr);
    }

    public void recoverTree(TreeNode root) {
        List<TreeNode> arr = new ArrayList<>();
        inorder(root, arr);

        List<Integer> values = new ArrayList<>();

        for (TreeNode node : arr) {
            values.add(node.val);
        }

        Collections.sort(values);

        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).val = values.get(i);
        }
    }
}