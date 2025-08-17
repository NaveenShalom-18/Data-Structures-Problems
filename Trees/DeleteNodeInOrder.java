package Trees;
import java.util.*;

public class DeleteNodeInOrder {

    // Insert into BST
    public static TreeNode bst(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = bst(root.left, val);
        else root.right = bst(root.right, val);
        return root;
    }

    // Inorder traversal
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // Delete node in BST
    public static TreeNode delete(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = delete(root.left, key);
        } else if (key > root.val) {
            root.right = delete(root.right, key);
        } else {
            // Node found
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = delete(root.right, successor.val);
        }
        return root;
    }

    // Find minimum value node (inorder successor)
    public static TreeNode findMin(TreeNode root) {
        while (root.left != null) root = root.left;
        return root;
    }

    public static void main(String[] args) {
        int arr[] = {10, 5, 15, 2, 7};
        TreeNode root = null;

        // Build BST
        for (int val : arr) {
            root = bst(root, val);
        }

        System.out.println("Inorder before deletion:");
        inorder(root);

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter node to delete: ");
        int key = sc.nextInt();

        root = delete(root, key);

        System.out.println("Inorder after deletion:");
        inorder(root);
    }
}
