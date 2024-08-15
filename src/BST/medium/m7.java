package BST.medium;

import binary_tree.TreeNode;

public class m7 {
    public static void main(String[] args) {
        Integer  [] arr={6,2,8,0,4,7,9,null,null,3,5};
        TreeNode root=lowestCommonAncestor(TreeNode.arrayToBinaryTree(arr),2,4);
        System.out.println(root.val);

    }
    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if(root==null)
        {
            return null;
        }
        if(p>root.val && q>root.val)
        {
             return lowestCommonAncestor(root.right,p,q);
        }
        if(p < root.val && q<root.val)
        {
           return lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }
}
