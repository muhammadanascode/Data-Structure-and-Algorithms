package Trees;

public class BinaryTree {
    TreeNode root;

    private class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void preOrder(TreeNode root){
        if (root == null) {
            return ;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode root){
        if (root == null) {
            return ;
        }
        preOrder(root.left);
        System.out.println(root.data);
        preOrder(root.right);
    }

    public void postOrder(TreeNode root){
        if (root == null) {
            return ;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.data);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree() ;
    }

}
