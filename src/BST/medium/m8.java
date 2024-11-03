package BST.medium;

import binary_tree.TreeNode;

public class m8 {
    public static void main(String[] args) {
    }
    public static TreeNode bstFromPreorder(int[] preorder) {
        return  generateBst(Integer.MAX_VALUE,preorder,new int[]{0});
    }
    public static TreeNode generateBst(int ub,int [] pre,int [] index)
    {
        if(index[0]==pre.length || pre[index[0]]>ub)
        {
            return null;
        }
        TreeNode node=new TreeNode(pre[index[0]++]);
        int val=node.val;
        node.left=generateBst(node.val,pre,index);
        node.right=generateBst(ub,pre,index);
        return node;
    }
}
