package binary_tree;

import java.util.*;

public class m8 {
    public static void main(String[] args) {
        Integer [] arr={1,2,3,4};
        System.out.println(rightSideView(TreeNode.arrayToBinaryTree(arr)));
    }
    public static List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size= queue.size();
            List<Integer> arr=new ArrayList<>();
            for (int i = 0; i < size ; i++) {
                TreeNode node=queue.poll();
                arr.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(arr.getLast());
        }
        return ans;

    }
}
