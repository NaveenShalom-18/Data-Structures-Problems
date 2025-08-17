package Trees;
import java.util.*;
public class LevelOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        TreeNode root = null;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        root = insertlevelOrder(arr);
        levelOrderTraversal(root);
    }
    public static void levelOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.left != null) {
                q.add(node.left);
            }
            if(node.right != null) {
                q.add(node.right);
            }
            System.out.print(node.val + " ");
        }
    }
    public static TreeNode insertlevelOrder(int nums[]) {
        int n = nums.length;
        if(n == 0) return null;
        TreeNode root = new TreeNode(nums[0]);

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        int i = 1;
        while(i < n) {
            TreeNode cur = q.poll();
                cur.left = new TreeNode(nums[i++]);
                q.add(cur.left);
            if(i < n){
                cur.right = new TreeNode(nums[i++]);
                q.add(cur.right);
            }
        }

        return root;
    }
}
