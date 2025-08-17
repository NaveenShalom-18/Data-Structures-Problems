package Trees;

import java.util.*;
class PerfectBT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        TreeNode root = null;
        root = insertLevelOrder(arr);
        Set<Integer> set = new HashSet<>();
        if(dfs(root,set,0)) {
            System.out.print("Yes");
        }
        else {
            System.out.print("No");
        }

    }
    public static boolean dfs(TreeNode root, Set<Integer> set, int depth) {
        if(root == null) return true;
        if(root.left == null && root.right == null) {
            set.add(depth);
            return true;
        }
        if(root.left == null || root.right == null) return false;
        boolean t1 = dfs(root.left,set,depth+1);
        boolean t2 = dfs(root.right,set,depth+1);
        return (t1 && t2) && set.size() == 1;
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