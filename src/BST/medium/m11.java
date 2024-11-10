package BST.medium;

import binary_tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class m11 {
    public static void main(String[] args) {
    Integer [] arr={5,3,6,2,4,null,7};
        System.out.println(findTarget(TreeNode.arrayToBinaryTree(arr),9));
    }
    public static boolean findTarget(TreeNode root, int k) {
            return helper(root,k,new HashSet<>());
    }
    public static boolean helper(TreeNode root, int k, Set<Integer> memo)
    {
        if(root==null)
        {
            return false;
        }
        if(memo.contains(k-root.val))
        {
            return true;
        }
        memo.add(root.val);
        boolean left=helper(root.left,k,memo);
        boolean right=helper(root.right,k,memo);
        return left || right;
    }
}
