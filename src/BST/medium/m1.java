package BST.medium;

import binary_tree.TreeNode;

public class m1 {
    public static void main(String[] args) {
        Integer [] arr={10,5,11,4,7,null,null,null,null,null,8};
        System.out.println(findCeil(TreeNode.arrayToBinaryTree(arr),6));

    }
    static int findCeil(TreeNode root, int key) {
        if (root == null) return -1;
        int ceil=-1;
        TreeNode curr=root;
        while(curr!=null)
        {
            if(curr.val>=key)
            {
                ceil=curr.val;
                curr=curr.left;
            }
            else {
                curr=curr.right;
            }
        }
        return ceil;

    }
}
