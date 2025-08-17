package Trees;

import java.util.*;

class BalancedBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        TreeNode root = insertBalanceBST(arr,0,n-1);
        inorder(root);
    }
    public static TreeNode insertBalanceBST(int arr[], int start, int end) {
        if(start > end) return null;
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = insertBalanceBST(arr,start,mid-1);
        node.right = insertBalanceBST(arr,mid+1,end);
        return node;
    }
    public static void inorder(TreeNode root) {
        if(root != null) {
            System.out.print(root.val+" ");
            inorder(root.left);
            inorder(root.right);
        }
    }
}