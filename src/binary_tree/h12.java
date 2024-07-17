package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class h12 {
    public static void main(String[] args) {
        Integer [] arr={1,2,3,4,5,null,null,null,null,null,6};
        System.out.println(inorderTraversal(TreeNode.arrayToBinaryTree(arr)));
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> arr=new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null)
        {
            if(curr.left==null)
            {
                arr.add(curr.val);
                curr=curr.right;
            }
            else{
                TreeNode prev=curr.left;
                while(prev.right!=null && prev.right!=curr)
                {
                    prev=prev.right;
                }
                if(prev.right==null)
                {
                    prev.right=curr;
                    curr=curr.left;
                }
                else {
                    prev.right=null;
                    arr.add(curr.val);
                    curr=curr.right;

                }

            }
        }
        return arr;


    }

}
