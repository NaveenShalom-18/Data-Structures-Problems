package Trees;

import java.util.*;
class DistanceBetweenBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeNode root = null;
        int arr[] = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
            root = bst(root,arr[i]);
        }
        int left = sc.nextInt();
        int right = sc.nextInt();
        int count = distanceBetween(root,left,right);
        System.out.print(count);
    }
    public static TreeNode findCommonAnces(TreeNode root, int left, int right) {
        if(root.val > left && root.val > right) root = root.left;
        else if(root.val < left && root.val < right) root = root.right;
        return root;
    }
    public static int findDistance(TreeNode root, int value) {
        int depth = 0;
        while(root!=null) {
            if(root.val < value) {
                root = root.right;
                depth++;
            }
            else if(root.val> value) {
                root = root.left;
                depth++;
            }
            else {
                return depth;
            }
        }
        return -1;
    }
    public static int distanceBetween(TreeNode root,int left,int right) {
        TreeNode ancesRoot = findCommonAnces(root,left,right);
        int d1 = findDistance(ancesRoot,left);
        int d2 = findDistance(ancesRoot,right);

        return d1+d2;
    }
    public static TreeNode bst(TreeNode root, int num) {
        if(root == null) return new TreeNode(num);
        if(root.val > num) {
            root.left = bst(root.left, num);
        }
        else if(root.val < num) {
            root.right = bst(root.right, num);
        }
        return root;
    }
}