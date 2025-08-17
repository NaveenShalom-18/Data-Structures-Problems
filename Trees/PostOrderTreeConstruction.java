package Trees;

import java.util.*;

public class PostOrderTreeConstruction {
    public static void postOrder(TreeNode root, List<Integer> newlst) {
        if (root == null) return;
        postOrder(root.left, newlst);
        postOrder(root.right, newlst);
        newlst.add(root.val);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeNode nodes[] = new TreeNode[n];
        boolean isChild[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(0);
        }
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            int left = sc.nextInt();
            int right = sc.nextInt();
            nodes[i].val = val;
            if(left != -1) {
                nodes[i].left = nodes[left];
                isChild[left] = true;
            }
            if(right != -1) {
                nodes[i].right = nodes[right];
                isChild[right] = true;
            }
        }
        int rootindex = 0;
        for(int i = 0; i < n; i++) {
            if(!isChild[i]) {
                rootindex = i;
                break;
            }
        }
        List<Integer> newlst = new ArrayList<>();
        postOrder(nodes[rootindex], newlst);
        System.out.println(newlst);
    }
}
