package Trees;

import java.util.Stack;

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

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    // preorder using iterative approach
    public void preOrderI(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.println(temp.data);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }

    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        System.out.println(root.data);
        preOrder(root.right);
    }

    public void inOrderI(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.println(temp.data);
                temp = temp.right;
            }
        }

    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.data);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
    }

}
