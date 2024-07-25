package BST.medium;

import binary_tree.TreeNode;

public class m2 {
    public static void main(String[] args) {
        Integer [] arr={10,5,11,4,7,null,null,null,null,null,8};
        System.out.println(floor(TreeNode.arrayToBinaryTree(arr),7));
    }
    public static int floor(TreeNode root, int x) {
        if(root==null) return -1;
        int floor=-1;
        TreeNode curr=root;
        while(curr!=null)
        {
            if(curr.val==x)
            {
                floor= curr.val;
                return floor;
            }
            if(x<curr.val)
            {
                curr=curr.left;
                if(curr!=null)
                {
                    floor=curr.val;
                }
            }
            else {
                curr=curr.right;
            }
        }
        return floor;
    }
}
