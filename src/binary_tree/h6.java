package binary_tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
    public static Node arrayToBinaryTree(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        // Create the root of the tree
        Node root = new Node(arr[0]);

        // Use a queue to keep track of nodes and their positions
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < arr.length) {
            Node current = queue.poll();

            // Add the left child
            if (i < arr.length && arr[i] != null) {
                current.left = new Node(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Add the right child
            if (i < arr.length && arr[i] != null) {
                current.right = new Node(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

}
public class h6 {
    public static void main(String[] args) {
        Integer [] arr={1, 2, 3, 4, 5, null, 6, null, null, 7, 8, null, 9, null, null, null, null, null, 10};
        System.out.println(minTime(Node.arrayToBinaryTree(arr),8));

    }
    static Map<Integer,Integer> mpp=new HashMap<>();

    public static int minTime(Node root, int target)
    {
        int [] ans= new int [1];
        find(root,target);
        dfs(root,target,mpp.get(root.data),ans);
        return ans[0];
    }
    public static int find(Node root, int target)
    {
        if(root==null) return -1;
        if(root.data==target)
        {
            mpp.put(root.data,0);
            return 0;
        }
        int left=find(root.left,target);
        if(left>=0)
        {
            mpp.put(root.data,left+1);
            return left+1;
        }
        int right=find(root.right,target);
        if(right>=0)
        {
            mpp.put(root.data,right+1);
            return right+1;
        }
        return -1;
    }
    public static void dfs(Node root, int target, int length,int [] ans )
    {
        if(root ==null)
        {
            return;
        }
        if(mpp.containsKey(root.data))
        {
            length=mpp.get(root.data);
        }
        ans[0]=length;
        dfs(root.left,target,length+1,ans);
        dfs(root.right,target,length+1,ans);
    }
}
