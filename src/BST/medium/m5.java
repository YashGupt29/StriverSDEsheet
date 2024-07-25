package BST.medium;

import binary_tree.TreeNode;

public class m5 {
    public static void main(String[] args) {
        Integer [] arr={3,1,4,null,2};
        System.out.println(kthSmallest(TreeNode.arrayToBinaryTree(arr),1));
    }
    public static int kthSmallest(TreeNode root, int k) {
        int [] ans=new int[1];
        int [] smallest=new int [1];
        helper(root,k,ans,smallest);
        return ans[0];

    }
    public static void helper(TreeNode root, int k,int [] ans,int [] smallest)
    {
        if(root==null || smallest[0]>=k)
        {
            return;
        }
        helper(root.left,k,ans,smallest);
        smallest[0]+=1;
        if(smallest[0]==k)
        {
            ans[0]=root.val;
            return;

        }
        helper(root.right,k,ans,smallest);


    }
}
