package binary_tree;

public class m9 {
    public static void main(String[] args) {
        Integer [] arr={1,2,2,3,4,4,3};
        System.out.println(isSymmetric(TreeNode.arrayToBinaryTree(arr)));
    }
    public static boolean isSymmetric(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        return helper(root.left,root.right);
    }
    public static boolean helper(TreeNode node1,TreeNode node2)
    {
        if(node1==null || node2 ==null)
        {
            return node1==node2;
        }
        boolean ansleft=helper(node1.left,node2.right);
        boolean ansright=helper(node2.right,node1.left);
        return node1.val==node2.val && ansleft && ansright;


    }
}
