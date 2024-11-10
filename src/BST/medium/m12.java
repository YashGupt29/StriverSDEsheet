package BST.medium;

import binary_tree.TreeNode;

public class m12 {
    public static void main(String[] args) {
        Integer [] arr={3,1,4,null,null,2};
        TreeNode root=TreeNode.arrayToBinaryTree(arr);
        System.out.println(TreeNode.treeToArray(root));

        recoverTree(root);
        System.out.println(TreeNode.treeToArray(root));

    }
    public static void recoverTree(TreeNode root) {
        TreeNode[] first = {null};
        TreeNode[] second = {null};
        TreeNode[] prev = {new TreeNode(Integer.MIN_VALUE)};

        fetch(root, first, second, prev);

        if (first[0] != null && second[0] != null) {
            int temp = first[0].val;
            first[0].val = second[0].val;
            second[0].val = temp;
        }
    }

    public static void fetch(TreeNode root, TreeNode[] first, TreeNode[] second, TreeNode[] prev) {
        if (root == null) {
            return;
        }

        fetch(root.left, first, second, prev);

        if (prev[0] != null && prev[0].val > root.val) {
            if (first[0] == null) {
                first[0] = prev[0];
            }
            second[0] = root;
        }

        prev[0] = root;

        fetch(root.right, first, second, prev);
    }
}
