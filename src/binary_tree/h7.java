package binary_tree;

public class h7 {
    public static void main(String[] args) {
    Integer [] arr={1,2,3,4,5,6};
        System.out.println(countNodes(TreeNode.arrayToBinaryTree(arr)));
    }
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = countLeft(root);
        int rh = countRight(root);
        if (lh == rh) {
            return ((2 << lh) - 1);
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;

        }

    }

    public static int countLeft(TreeNode root) {
        int height = 0;
        while (root.left != null) {
            height++;
            root = root.left;
        }
        return height;
    }

    public static int countRight(TreeNode root) {
        int height = 0;
        while (root.right != null) {
            height++;
            root = root.right;
        }
        return height;
    }
}
