package BST.medium;

import binary_tree.TreeNode;

public class m9 {
    public static void main(String[] args) {
        Integer [] arr={15,10,16,1,14,null,81,null,8,12,null,63,34};
        TreeNode ans=inorderSuccessor(TreeNode.arrayToBinaryTree(arr),new TreeNode(1));
        System.out.println(ans==null?-1:ans.val);
    }
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode x) {
        TreeNode successor = null;

        while (root != null) {
            if (x.val < root.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return successor;
    }

}
