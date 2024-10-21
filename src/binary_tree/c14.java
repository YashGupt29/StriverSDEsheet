package binary_tree;

public class c14 {
    public static void main(String[] args) {
        int [] pre={40 ,30, 35, 80, 100};
        System.out.println(Bst(pre,pre.length));
    }
    public static TreeNode Bst(int pre[], int size) {
        return  generateBst(Integer.MAX_VALUE,pre,new int[]{0});

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
