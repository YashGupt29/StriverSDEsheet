package binary_tree;

public class m3 {
    public static void main(String[] args) {
        Integer [] p={1,2,1};
        Integer [] q={1,1,2};
        System.out.println(isSameTree(TreeNode.arrayToBinaryTree(p),TreeNode.arrayToBinaryTree(q)));

    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
        {
            return true;
        }
        if(p==null || q==null)
        {
            return false;
        }
        if(p.val!=q.val)
        {
            return false;
        }
       boolean left= isSameTree(p.left,q.left);
       boolean right= isSameTree(p.right,q.right);

        return left && right;
    }
}
