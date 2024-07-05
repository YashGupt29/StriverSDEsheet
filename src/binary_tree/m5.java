package binary_tree;

import java.util.*;

public class m5 {
    public static void main(String[] args) {
        Integer [] arr={1,2,3,4,6,5,7};
        System.out.println(verticalTraversal(TreeNode.arrayToBinaryTree(arr)));
    }
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> ans=new ArrayList<>();
            if(root==null) return ans;
            TreeMap<Integer,TreeMap<Integer,List<Integer>>> mpp=new TreeMap<>();
            Queue<Triplet> queue= new LinkedList<>();
            queue.add(new Triplet(root,0,0));
            while(!queue.isEmpty())
            {
                Triplet current=queue.poll();
                TreeNode node=current.node;
                int hd=current.hd;
                int vd=current.vd;
                mpp.putIfAbsent(hd,new TreeMap<>());
                mpp.get(hd).putIfAbsent(vd,new ArrayList<>());
                mpp.get(hd).get(vd).add(node.val);
                if(node.left!=null)
                {
                    queue.add(new Triplet(node.left,hd-1,vd+1));
                }
                if(node.right!=null)
                {
                    queue.add(new Triplet(node.right,hd+1,vd+1));
                }
            }
           for(TreeMap<Integer,List<Integer>> vertical: mpp.values())
           {
               List<Integer> arr=new ArrayList<>();
               for(List<Integer> node:vertical.values())
               {
                   Collections.sort(node);
                   arr.addAll(node);
               }
               ans.add(arr);
           }
            return ans;
    }


}
class Triplet {
    TreeNode node;
    int hd;
    int vd;
    Triplet(TreeNode node,int hd,int vd)
    {
        this.node=node;
        this.hd=hd;
        this.vd=vd;
    }
}