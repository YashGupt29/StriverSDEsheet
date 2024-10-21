package binary_tree;

import java.util.HashMap;

public class m2 {
    public static void main(String[] args) {
        Integer[] arr = {1 ,2 ,3 ,4 ,5 ,null ,6 ,null, null ,7 ,8 ,null,9 };
        TreeNode root=TreeNode.arrayToBinaryTree(arr);
        System.out.println(minTime(root,8));
    }
    static HashMap<Integer,Integer> preCall=new HashMap<>();
    public static int minTime(TreeNode root, int target)
    {
        int [] max=new int [1];
        find(root,target);
        dfs(root,preCall.get(root.val),max);
        System.out.println(preCall.get(root.val));
        return max[0];
    }
    public static int find(TreeNode root,int target)
    {
        if(root==null)
        {
            return -1;
        }
        if(root.val==target)
        {
            preCall.put(root.val,0);
            return 0;
        }
        int left=find(root.left,target);
        if(left>=0)
        {
            preCall.put(root.val,left+1);
            return left+1;
        }
        int right=find(root.right,target);
        if(right>=0)
        {
            preCall.put(root.val,right+1);
            return right+1;
        }
        return -1;
    }
    public static void dfs(TreeNode root,int length,int [] max)
    {
        if(root==null)
        {
            return;
        }
        if(preCall.containsKey(root.val))
        {
            length=preCall.get(root.val);
        }
        max[0]=Math.max(max[0],length);
        dfs(root.left,length+1,max);
        dfs(root.right,length+1,max);


    }
}
