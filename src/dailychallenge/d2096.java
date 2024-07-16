package dailychallenge;

import binary_tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class d2096 {
    public static void main(String[] args) {
        Integer [] arr={1,null,10,12,13,4,6,null,15,null,null,5,11,null,2,14,7,null,8,null,null,null,9,3};
        System.out.println(getDirections(TreeNode.arrayToBinaryTree(arr),6,15));
    }

    public static String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca=getLca(root,startValue,destValue);
        StringBuilder sb=new StringBuilder();
        pathtolca(lca,startValue,sb);
        StringBuilder bs=new StringBuilder();
        pathfromlca(lca,destValue,bs);
        bs.reverse();
        return sb.append(bs).toString();

    }
    public static TreeNode getLca(TreeNode root,int startvalue,int destvalue)
    {
        if(root==null || root.val==startvalue || root.val == destvalue)
        {
            return root;
        }
        TreeNode left=getLca(root.left,startvalue,destvalue);
        TreeNode right=getLca(root.right,startvalue,destvalue);
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
    public static  boolean pathtolca(TreeNode root,int start,StringBuilder sb)
    {
        if(root==null)
        {
            return false;
        }
        if(root.val==start)
        {
            return true;
        }
        if( pathtolca(root.left,start,sb))
        {
            sb.append("U");
            return true;
        }
        if( pathtolca(root.right,start,sb))
        {
            sb.append("U");
            return true;
        }
        return false;
    }
    public static  boolean pathfromlca(TreeNode root,int value,StringBuilder sb)
    {
        if(root==null)
        {
            return false;
        }
        if(root.val==value)
        {
            return true;
        }
        if(pathfromlca(root.left,value,sb))
        {
            sb.append("L");
            return true;
        }
        if(pathfromlca(root.right,value,sb))
        {
            sb.append("R");
            return true;
        }
        return false;
    }
}
