package binary_tree;

public class h14 {
    public static void main(String[] args) {
        Integer [] arr={1,2,5,3,4,null,6};

    }
    public static void flatten(TreeNode root) {
        TreeNode curr=root;
        while(curr!=null)
        {
            if(curr.left==null)
            {
                curr=curr.right;
            }
            else {
                TreeNode next=curr.right;
                TreeNode prev=curr.left;
                curr.right=prev;
                curr.left=null;
                while(prev.right!=null)
                {
                    prev=prev.right;
                }
                prev.right=next;
                curr=curr.right;
            }

        }

    }
}
