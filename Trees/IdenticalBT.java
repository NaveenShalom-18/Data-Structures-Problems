package Trees;

import java.util.*;

class IdenticalBT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<m;i++) {
            arr1[i] = sc.nextInt();
        }
        if(n!=m) {
            System.out.print("The given binary trees are not identical");
            return;
        }
        TreeNode root1 = insertLevelOrder(arr);
        TreeNode root2 = insertLevelOrder(arr1);
        boolean truth = equalOrNot(root1,root2);
        if(truth) System.out.print("The given binary trees are identical");
        else System.out.print("The given binary trees are not identical");
    }
    public static boolean equalOrNot(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        boolean truth1 = equalOrNot(root1.left,root2.left);
        boolean truth2 = equalOrNot(root1.right,root2.right);
        return truth1 && truth2;
    }
    public static TreeNode insertLevelOrder(int arr[]) {
        int n = arr.length;
        if(n == 0) return null;
        Queue<TreeNode> q = new LinkedList();
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