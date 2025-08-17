package Trees;

import java.util.*;

public class PreOrderThreshold {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeNode root = null;
        int arr[] = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        root = insert(arr);
        int threshold = sc.nextInt();
        List<Integer> lst = new ArrayList<>();
        lst = preorderList(root,threshold,lst);
        if(lst.isEmpty()) {
            System.out.print(-1);
        }
        else {
            for(int num : lst) {
                System.out.print(num+" ");
            }
        }
    }
    public static List<Integer> preorderList(TreeNode root,int threshold,List<Integer> lst) {
        if(root == null) return new ArrayList<>();
        if(root.val < threshold) {
            lst.add(root.val);
        }
        preorderList(root.left,threshold,lst);
        preorderList(root.right,threshold,lst);
        return lst;
    }
    public static TreeNode insert(int arr[]) {
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