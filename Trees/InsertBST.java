package Trees;

import java.util.*;
class InsertBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n<=0) {
            System.out.print("Tree is empty");
            return;
        }
        int arr[] = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        int ins = sc.nextInt();
        TreeNode root = null;
        root = insertLevelOrder(arr);
        root = insertSpecificNode(root, ins);
        levelOrder(root);
    }
    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode head = q.poll();
            System.out.print(head.val+" ");
            if(head.left != null) {
                q.add(head.left);
            }
            if(head.right != null) {
                q.add(head.right);
            }
        }
    }
    public static TreeNode insertSpecificNode(TreeNode root,int ins) {
        if(root == null) return new TreeNode(ins);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode head = q.poll();
            if(head.left == null) {
                head.left = new TreeNode(ins);
                break;
            }
            else {
                q.add(head.left);
            }
            if(head.right == null) {
                head.right = new TreeNode(ins);
                break;
            }
            else {
                q.add(head.right);
            }
        }
        return root;
    }
    public static TreeNode insertLevelOrder(int arr[]) {
        int n = arr.length;
        if(n == 0) return null;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        q.add(root);
        int i = 1;
        while(i < n) {
            TreeNode curr = q.poll();
            curr.left = new TreeNode(arr[i++]);
            q.add(curr.left);
            if(i < n) {
                curr.right = new TreeNode(arr[i++]);
                q.add(curr.right);
            }
        }
        return root;
    }
}