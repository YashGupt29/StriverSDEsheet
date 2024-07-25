package BST.medium;

import binary_tree.TreeNode;

public class m3 {
    public static void main(String[] args) {
        Integer [] arr={61,46,66,43,null,null,null,39,null,null,null};
        System.out.println(insertIntoBST(TreeNode.arrayToBinaryTree(arr),88));
    }
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node=new TreeNode(val);
        TreeNode curr=root;
        TreeNode prev=root;
        while(curr!=null)
        {
            if(val>curr.val)
            {
                prev=curr;
                curr=curr.right;
            }
            else {
                prev=curr;
                curr=curr.left;
            }
        }
        if(val>prev.val)
        {
            prev.right=node;

        }else{
            prev.left=node;
        }
        return root;
    }
}
