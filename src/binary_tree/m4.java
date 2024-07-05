package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class m4 {
    public static void main(String[] args) {
        Integer [] arr={3,9,20,null,null,15,7};
        System.out.println(zigzagLevelOrder(TreeNode.arrayToBinaryTree(arr)));


    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            List<Integer> arr= new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode node=queue.poll();
                if (leftToRight) {
                    arr.add(node.val);
                } else {
                    arr.add(0, node.val);
                }

                if(node.left!=null)
                {
                    queue.add(node.left);
                }
                if(node.right!=null)
                {
                    queue.add(node.right);
                }

            }
            leftToRight=!leftToRight;
            ans.add(arr);
        }
        return ans;

    }
}
