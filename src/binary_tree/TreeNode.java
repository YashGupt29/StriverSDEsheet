package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
      public TreeNode left;
     public TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right)
      {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    public static TreeNode arrayToBinaryTree(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        // Create the root of the tree
        TreeNode root = new TreeNode(arr[0]);

        // Use a queue to keep track of nodes and their positions
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();

            // Add the left child
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Add the right child
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

}


