package BST;

import binary_tree.TreeNode;

public class m13 {
    public static void main(String[] args) {

    }
    public static int largestBst(TreeNode root)
    {
        Triplet ans= helper(root);
        return ans.size;
    }
    public static Triplet helper(TreeNode root)
    {
        if(root==null)
        {
            return new Triplet(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
        }
        Triplet left=helper(root.left);
        Triplet right=helper(root.right);
        if(left.largest<root.val && root.val>right.smallest)
        {
            return new Triplet(Math.min(root.val,left.smallest),Math.max(root.val,right.largest),left.size + right.size + 1);
        }
        return new Triplet(Integer.MAX_VALUE,Integer.MIN_VALUE,Math.max(left.size,right.size));
    }
    static class Triplet {
        int largest;
        int smallest;
        int size;
        Triplet(int largest,int smallest,int size)
        {
            this.largest=largest;
            this.smallest=smallest;
            this.size=size;
        }
    }
}
