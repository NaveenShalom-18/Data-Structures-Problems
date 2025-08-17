package Trees;

import java.util.*;

class FreqBST {
    static TreeNodeFreq root = null;
    static TreeNodeFreq mostfreq = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String word = sc.next();
            if(word.equals("end")) break;
            root = insert(root,word);
        }
        System.out.println("Words in alphabetical order:");
        inorder(root);
        System.out.print("The most frequent word: "+mostfreq.name+" ("+mostfreq.freq+" times)");
    }
    public static void inorder(TreeNodeFreq root) {
        if(root == null) return;
        inorder(root.left);
        System.out.println(root.name+" ("+root.freq+" times)");
        inorder(root.right);
    }
    public static TreeNodeFreq insert(TreeNodeFreq root, String str) {
        if(root == null) {
            TreeNodeFreq newnode = new TreeNodeFreq(str);
            updateFreq(newnode);
            return newnode;
        }
        int cmp = root.name.compareTo(str);
        if(cmp == 0) {
            root.freq++;
            updateFreq(root);
        }
        else if(cmp > 0){
            root.left = insert(root.left,str);
        }
        else {
            root.right = insert(root.right,str);
        }
        return root;
    }
    public static void updateFreq(TreeNodeFreq node) {
        if(mostfreq == null || node.freq > mostfreq.freq || (node.freq == mostfreq.freq && node.name.compareTo(mostfreq.name) < 0)) {
            mostfreq = node;
        }
    }
}