package BST;

import binary_tree.TreeNode;

public class e1 {
    public static void main(String[] args) {
        Integer [] arr={4,2,7,1,3};
        int val=2;
        System.out.println(searchBST(TreeNode.arrayToBinaryTree(arr),val));


    }
    public static TreeNode searchBST(TreeNode root, int val) {
        TreeNode curr=root;
       while(curr!=null)
       {
           if(curr.val==val)
           {
               return curr;
           }
           if(curr.val<val)
           {
               curr=curr.right;
           }
           else{
               curr=curr.left;
           }
       }
       return null;
    }
}
