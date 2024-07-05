package binary_tree;

import java.util.*;

public class m5 {
    public static void main(String[] args) {
        Integer [] arr={3,9,20,null,null,15,7};
        verticalTraversal(TreeNode.arrayToBinaryTree(arr));
    }
    public static void verticalTraversal(TreeNode root) {
        HashMap<Integer,HashMap<Integer,Integer>> mpp=new HashMap<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        HashMap<Integer,Integer> innermap=new HashMap<>();
        innermap.put(0,0);
        mpp.put(root.val,innermap);

        while(!queue.isEmpty())
        {
            int size=queue.size();
            for (int i = 0; i <size ; i++) {
                int x = 0;
                int y = 0;
                TreeNode node=queue.poll();

                innermap = mpp.getOrDefault(node.val, new HashMap<>());

                if(node.left!=null)
                {
                    x=innermap.getOrDefault(0,0)-1;
                    y=innermap.getOrDefault(0,0)+1;
                    innermap.put(x,y);
                    mpp.put(node.left.val,innermap);
                    queue.add(node.left);
                }
                if(node.right!=null)
                {
                    x = innermap.getOrDefault(0, 0);
                    y = innermap.getOrDefault(0, 0) + 2;
                    innermap.put(x, y);
                    mpp.put(node.right.val,innermap);
                    queue.add(node.right);
                }

            }
            printNestedHashMap(mpp);
        }
    }
    public static void printNestedHashMap(HashMap<Integer, HashMap<Integer, Integer>> map) {
        // Traverse outer HashMap
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : map.entrySet()) {
            int outerKey = entry.getKey();
            HashMap<Integer, Integer> innerMap = entry.getValue();

            // Traverse inner HashMap
            for (Map.Entry<Integer, Integer> innerEntry : innerMap.entrySet()) {
                int innerKey = innerEntry.getKey();
                int innerValue = innerEntry.getValue();

                // Print in the desired format
                System.out.println("(" + outerKey + ",(" + innerKey + "," + innerValue + "))");
            }
        }
    }


}
