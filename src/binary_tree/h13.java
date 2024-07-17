package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class h13 {
    public static void main(String[] args) {
        Integer [] arr={1,2,3,4,5,null,null,null,null,null,6};
        System.out.println(inorderTraversal(TreeNode.arrayToBinaryTree(arr)));
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        TreeNode curr=root;
        while (curr!=null)
        {
            if(curr.left==null)
            {
                ans.add(curr.val);
                curr=curr.right;
            }
            else {
                TreeNode next=curr.right;
                TreeNode prev=curr.left;
                while(prev.right!=null && prev.right!=next)
                {
                    prev=prev.right;
                }
                if(prev.right==null)
                {
                    prev.right=next;
                    ans.add(curr.val);
                    curr=curr.left;
                }else {
                   prev.right=null;
                   curr=curr.right;
                }
            }
        }
        return ans;
    }
}
