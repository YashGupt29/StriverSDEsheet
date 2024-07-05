package binary_tree;

import java.util.*;

public class m6 {
    public static void main(String[] args) {
        Integer [] arr={1,2,3,4,5,6,7};
        System.out.println(topView(TreeNode.arrayToBinaryTree(arr)));
    }
    public static ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,Integer>> mpp=new TreeMap<>();
        Queue<Triplet> queue=new LinkedList<>();
        queue.add(new Triplet(root,0,0));
        while(!queue.isEmpty())
        {
            Triplet cur=queue.poll();
            TreeNode node=cur.node;
            int hd= cur.hd;
            int vd= cur.vd;
            if(!mpp.containsKey(hd))
            {
                mpp.putIfAbsent(hd,new TreeMap<>());
                mpp.get(hd).putIfAbsent(vd,node.val);
            }
            if(node.left!=null)
            {
                queue.add(new Triplet(node.left,hd-1,vd+1));
            }
            if(node.right!=null)
            {
                queue.add(new Triplet(node.right,hd+1,vd+1));

            }
        }
        for(TreeMap<Integer,Integer> arr:mpp.values())
        {
            ans.addAll(arr.values());

        }

        return ans;
    }

}

