package BST.medium;
import binary_tree.TreeNode;

public class m6 {
    public static void main(String[] args) {
        Integer [] arr={5,1,4,null,null,3,6};
        System.out.println(isValidBST(TreeNode.arrayToBinaryTree(arr),Long.MIN_VALUE, Long.MAX_VALUE));
    }

    public static boolean isValidBST(TreeNode root,long min,long max) {
        if(root==null)
        {
            return true;
        }
        if(root.val<=min || root.val>=max)
        {
            return false;
        }
        boolean left=isValidBST(root.left,min,root.val);
        boolean right=isValidBST(root.right,root.val,max);
        return left && right;
    }
}
