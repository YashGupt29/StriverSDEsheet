package binary_tree;

public class m1 {
    public static void main(String[] args) {
        int [] arr={1,2};
        TreeNode root=TreeNode.arrayToBinaryTree(arr);
        System.out.println(diameterOfBinaryTree(root));

    }
    public static int diameterOfBinaryTree(TreeNode root) {

        int [] max=new int[1];
        helper(root,max);
        return max[0];

    }
    public static int helper(TreeNode root, int [] max)
    {
        if(root==null)
        {
            return 0;
        }
        int left=helper(root.left,max);
        int right=helper(root.right,max);
        max[0]=Math.max(left+right,max[0]);
        return 1+Math.max(left,right);
    }
}
