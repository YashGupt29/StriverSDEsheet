package binary_tree;

import binary_tree.TreeNode;

import java.util.ArrayList;

public class h1 {
    public static void main(String[] args) {
        Integer [] arr={10,20,30,40,60};
        System.out.println(Paths(TreeNode.arrayToBinaryTree(arr)));

    }
    public static ArrayList<ArrayList<Integer>> Paths(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        helper(root,ans,arr);
        return ans;


    }
    public static  void helper( TreeNode root ,ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> arr)
    {
        if(root==null)
        {
            return;
        }
        arr.add(root.val);

        if(root.right==null && root.left==null)
        {
           ans.add(new ArrayList<>(arr));
        }
        else
        {
            helper(root.left,ans,arr);
            helper(root.right,ans,arr);
        }
        arr.remove(arr.size()-1);

    }
}
