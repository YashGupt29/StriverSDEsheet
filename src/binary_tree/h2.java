package binary_tree;

public class h2 {
    public static void main(String[] args) {
        Integer [] arr={3,5,1,6,2,0,8,null,null,7,4};


    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null || root==p || root == q)
        {
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        return (left!=null && right!=null)?root:null;
    }
}
