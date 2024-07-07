package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class h4 {
    public static void main(String[] args) {
        Integer [] arr={1,4,3,5};
        System.out.println(isSumProperty(TreeNode.arrayToBinaryTree(arr)));

    }
    public static int isSumProperty(TreeNode root)
    {
        return helper(root)==0?0:1;

    }
    public  static  int helper(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=helper(root.left);
        int right=helper(root.right);
        if(root.left!=null && root.right!=null && root.val!=(left+right))
        {
            return 0;
        }
        return root.val;
    }

}
