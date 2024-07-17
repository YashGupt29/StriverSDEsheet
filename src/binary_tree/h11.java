package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class h11 {
    public static void main(String[] args) {
        Integer [] arr={1,2,3,null,null,4,5};
        System.out.println(serialize(TreeNode.arrayToBinaryTree(arr)));
    }
    public static String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size= queue.size();
            for (int i = 0; i <size ; i++) {
                TreeNode node=queue.poll();
                if(node==null)
                {
                    sb.append("#").append(",");
                }else {
                    sb.append(node.val).append(",");
                    queue.add(node.left);
                    queue.add(node.right);
                }

            }
        }
        return sb.toString();

    }
}
