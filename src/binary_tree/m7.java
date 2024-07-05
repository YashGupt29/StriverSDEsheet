package binary_tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class m7 {
    public static void main(String[] args) {
        Integer [] arr={20, 8, 22, 5, 3, null, 25, null, null, 10, 14};
        System.out.println(bottomView(TreeNode.arrayToBinaryTree(arr)));


    }
    public static ArrayList<Integer> bottomView(TreeNode root)
    {
        TreeMap<Integer,Integer> mpp=new TreeMap<>();
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(root,0));
        while(!queue.isEmpty())
        {
            Pair curr=queue.poll();
            TreeNode node=curr.node;
            int hd=curr.hd;
            mpp.put(hd, node.val);
            if(node.left!=null)
            {
                queue.add(new Pair(node.left,hd-1));
            }
            if(node.right!=null)
            {
                queue.add(new Pair(node.right,hd+1));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>(mpp.values());
        return ans;

    }
}
class Pair{
    TreeNode node;
    int hd;
    Pair(TreeNode node,int hd)
    {
        this.node=node;
        this.hd=hd;
    }
}