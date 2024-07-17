package binary_tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class h10 {
    public static void main(String[] args) {

    }
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int [] map=new int[9999];
        for (int i = 0; i < inorder.length; i++) {
            map[inorder[i]]=i;
        }
        return helper(inorder,0,inorder.length-1,postorder,postorder.length-1, 0,map);

    }
    public static  TreeNode helper(int [] inorder,int instart,int inend, int [] postorder,int poststart,int postend,int [] map)
    {
        if(instart>inend || postend>poststart)
        {
            return null;
        }
        TreeNode root=new TreeNode(postorder[poststart]);
        int inRoot=map[root.val];
        int numleft=inend-inRoot;
        root.right=helper(inorder,inRoot+1,inend,postorder,poststart-1,poststart-numleft,map);
        root.left=helper(inorder,instart,inRoot-1,postorder,poststart-numleft-1,postend,map);


        return root;

    }
}
