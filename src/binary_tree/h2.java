package binary_tree;

public class h2 {
    public static void main(String[] args) {
        Integer [] arr={3,5,1,6,2,0,8,null,null,7,4};
        System.out.println(lowestCommonAncestor(TreeNode.arrayToBinaryTree(arr),2,0));


    }
    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {

        if(root==null || root.val==p || root.val == q)
        {
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        if(left==null)
        {
            return right;
        }
        if(right==null)
        {
            return left;
        }
        return root;
    }

}
