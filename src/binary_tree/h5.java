package binary_tree;

import java.util.*;
public class h5 {
    public static void main(String[] args) {
        Integer [] arr={1,2,3,4,5,null,6,null,null,7,8,null,9};
        TreeNode node=new TreeNode(8);
        System.out.println(distanceK(TreeNode.arrayToBinaryTree(arr),node,2));

    }
    static Map<TreeNode, Integer> map = new HashMap<>();

    public static int distanceK(TreeNode root, TreeNode target, int K) {
        int [] ans=new int[1];
        find(root, target);
        dfs(root, target, K, map.get(root), ans);
        return ans[0];
    }
    public static int find(TreeNode root, TreeNode target)
    {
        if(root==null)
        {
            return -1;
        }
        if(root.val==target.val)
        {
            map.put(target,0);
            return 0;
        }
        int left=find(root.left,target);
        if(left>=0)
        {
            map.put(root,left+1);
            return left+1;
        }
        int right=find(root.right,target);
        if(right>=0)
        {
            map.put(root,right+1);
            return right+1;
        }
        return -1;
    }
    public static void dfs(TreeNode root,TreeNode target,int k,int length, int[] ans)
    {
        if(root==null)
        {
            return;
        }
        if(map.containsKey(root))
        {
            length=map.get(root);
        }
        ans[0]=length;
        dfs(root.left,target,k,length + 1 ,ans);
        dfs(root.right,target,k,length + 1,ans);

    }

}
