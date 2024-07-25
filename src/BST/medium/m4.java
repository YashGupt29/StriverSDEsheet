package BST.medium;

import binary_tree.TreeNode;

public class m4 {
    public static void main(String[] args) {
        Integer [] arr={9,8,12,5,null,10,13,3,7,null,11,null,null,2,4,6,8};
        TreeNode root=deleteNode(TreeNode.arrayToBinaryTree(arr),5);
        System.out.println(TreeNode.treeToArray(root));
    }
    public static TreeNode deleteNode(TreeNode root, int key) {
      if(root==null) return null;
      if(root.val==key)
      {
          return helper(root);
      }
      TreeNode curr=root;
      while(curr!=null)
      {
          if(curr.val>key)
          {
              if(curr.left!=null && curr.left.val==key)
              {
                  curr.left=helper(curr.left);
                  break;
              }
              else {
                  curr=curr.left;
              }
          }
          else {
              if(curr.right!=null && curr.right.val==key)
              {
                  curr.right=helper(curr.right);
                  break;
              }
              else {
                  curr=curr.right;
              }

          }
      }
      return root;

    }
    public static  TreeNode helper(TreeNode root)
    {
        if(root.left==null)
        {
            return root.right;
        }
        if(root.right==null)
        {
            return root.left;
        }
        TreeNode left= root.left;
        TreeNode right= root.right;
        TreeNode rightmost=findlastright(left);
        rightmost.right=right;
        return root.left;

    }
    public  static  TreeNode findlastright(TreeNode root)
    {

        while (root.right!=null)
        {
            root=root.right;
        }
        return root;
    }


}

