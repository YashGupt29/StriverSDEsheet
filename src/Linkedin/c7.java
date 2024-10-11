package Linkedin;
class Node
{
    int data;
    Node left, right;
    Node(int item)    {
        data = item;
        left = right = null;
    }
}
public class c7 {
    public static void main(String[] args) {

    }
    public static int findDist(Node root, int a, int b) {
        Node lowestCommonAncestor=findLCA(root,a,b);
        return dfs(lowestCommonAncestor,a)+dfs(lowestCommonAncestor,b);
    }
    public static int dfs(Node root,int a)
    {
        if(root==null)
        {
            return -1;
        }
        if(root.data==a)
        {
            return 1;
        }
        int left=  dfs(root.left,a);
        if(left!=-1)
        {
            return left+1;
        }
        int right= dfs(root.right,a);
        if(right!=-1)
        {
            return right+1;
        }
        return  -1;
    }
    public static Node findLCA(Node root,int a,int b)
    {
        if(root==null || root.data==a || root.data==b)
        {
            return root;
        }
        Node left= findLCA(root.left,a,b);
        Node right=findLCA(root.right,a,b);
        if(left==null)
        {
            return right;
        }
        if(right==null)
        {
            return left;
        }
        return root;
    }
}
