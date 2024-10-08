package Trees;

import java.util.LinkedList;
import java.util.Queue;
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
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
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

    // post order using Iterative approach
    public void postOrderI(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;

        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                TreeNode t = stack.peek().right;
                if (t == null) {
                    t = stack.pop();
                    System.out.println(t.data);
                    while (!stack.isEmpty() && t == stack.peek().right) {
                        t = stack.pop();
                        System.out.println(t.data);
                    }
                } else {
                    temp = t;
                }
            }
        }

    }

    public void levelTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.println(temp.data);
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }

    public int findMax(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);

        if (left > result) {
            result = left;
        }
        if (right > result) {
            result = right;
        }
        return result;
    }

    public void insert(int value) {
        this.root = insert(this.root, value);
    }

    public TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // searching specific key
    public boolean binarySearch(TreeNode root, int value, int i) {
        if (root == null) {
            System.out.println(i + " Iterations");
            return false;
        }
        if (root.data == value) {
            System.out.println(i + " Iterations");
            return true;
        } else if (value < root.data) {
            return binarySearch(root.left, value, i + 1);
        } else {
            return binarySearch(root.right, value, i + 1);
        }
    }

    // validating binary search tree
    public void validate() {
        boolean result = validate(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (result) {
            System.out.println("Binary Tree is valid");
        } else {
            System.out.println("Binary Tree isn't valid");
        }
    }

    public boolean validate(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        validate(root.left, min, root.data);
        if (root.data < min) {
            return false;
        }
        validate(root.right, root.data, max);
        if (root.data > max) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(9);
        tree.insert(6);
        tree.insert(4);
        tree.insert(7);
        tree.insert(2);

        // tree.inOrder(tree.root);
        // System.out.println(tree.binarySearch(tree.root, 4, 0));
        tree.validate();
    }

}
