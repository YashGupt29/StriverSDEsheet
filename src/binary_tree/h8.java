package binary_tree;

import java.util.HashMap;

public class h8 {
    public static void main(String[] args) {
        int [] pre={10,20,40,50,30,60};
        int [] in={40,20,50,10,60,30};
        System.out.println(buildTree(pre,in));

    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < inorder.length ; i++) {
            map.put(inorder[i],i);
        }
        return helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1,map);
    }
    public  static  TreeNode helper(int [] preorder, int [] inorder, int preStart, int preEnd, int inStart, int inEnd, HashMap<Integer,Integer> mpp)
    {
        if(preStart>preEnd || inStart>inEnd)
        {
            return null;
        }
        TreeNode root=new TreeNode(preorder[preStart]);
        int inRoot=mpp.get(root.val);
        int numLeft=inRoot-inStart;
       root.left=helper(preorder,inorder,preStart+1,preStart+numLeft,inStart,inRoot-1,mpp);
        root.right=helper(preorder,inorder,preStart + numLeft+1,preEnd,inRoot+1,preEnd,mpp);
        return root;

    }
}
