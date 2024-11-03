package dailychallenge;

import binary_tree.TreeNode;

import java.util.Arrays;

public class d951 {
    public static void main(String[] args) {
    Integer [] arr={1,2,3,4,5,6,null,null,null,7,8};
    Integer [] arr2={1,3,2,null,6,4,5,null,null,null,null,8,7};
        System.out.println(flipEquiv(TreeNode.arrayToBinaryTree(arr),TreeNode.arrayToBinaryTree(arr2)));
    }
    static int [] parent;
    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1!=null && root2!=null && root1.val!=root2.val)
        {
            return false;
        }
        if(root1!=null && root2==null)
        {
            return false;
        }
        parent=new int[10];
        dfs(root1,-1);
        boolean ans= dfsCheck(root2,-1);
        for (int i = 0; i < parent.length; i++) {
            if(parent[i]!=0)
            {
                return false;
            }
        }
        return ans;

    }
    public static boolean dfsCheck(TreeNode root,int par)
    {
        if(root==null)
        {
            return true;
        }

        if(parent[root.val]!=par)
        {
            return false;
        }
        if(parent[root.val]==par)
        {
            parent[root.val]=0;
        }
        boolean left=dfsCheck(root.left, root.val);
        if(!left)
        {
            return false;
        }
        boolean right=dfsCheck(root.right, root.val);
        if(!right)
        {
            return false;
        }
        return true;
    }
    public static void dfs(TreeNode root,int par)
    {
        if(root==null)
        {
            return ;
        }
        parent[root.val]=par;
        dfs(root.left,root.val);
        dfs(root.right,root.val);
    }
}
