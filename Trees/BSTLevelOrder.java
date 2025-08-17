package Trees;

import java.util.*;
class BSTLevelOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        TreeNode root = null;
        for(int i=0;i<str.length;i++) {
            int num = Integer.parseInt(str[i]);
            if(num > 0) {
                root = insert(root,num);
            }
        }
        levelOrder(root);
    }
    public static void levelOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr.left != null) {
                q.add(curr.left);
            }
            if(curr.right != null) {
                q.add(curr.right);
            }
            System.out.print(curr.val+" ");
        }
    }
    public static TreeNode insert(TreeNode root, int num) {
        if(root == null) {
            root = new TreeNode(num);
        }
        if(root.val > num) {
            root.left = insert(root.left,num);
        }
        else if(root.val < num) {
            root.right = insert(root.right,num);
        }
        return root;
    }
}