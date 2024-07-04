package binary_tree;

public class m2 {
    public static void main(String[] args) {
        Integer[] arr = {10, 9, -1, null, null, 15, 7};
        TreeNode root=TreeNode.arrayToBinaryTree(arr);
        System.out.println(maxPathSum(root));
    }
    public static int maxPathSum(TreeNode root) {
        int [] sum=new int [1];
        sum[0]=Integer.MIN_VALUE;
        helper(root,sum);
        return sum[0];

    }
    public static int helper(TreeNode root,int [] max)
    {
        if(root==null)
        {
            return 0;
        }
        int leftNode=Math.max(0,helper(root.left,max));
        int rightNode=Math.max(0,helper(root.right,max));
        max[0]=Math.max(max[0],leftNode+rightNode+root.val);

        return root.val+Math.max(leftNode,rightNode);
    }
}
