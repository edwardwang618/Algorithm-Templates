package tree.binarytree;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        List<Integer> list = new ArrayList<>();
        
        inorder(root, list);
        System.out.println(list);
    }
    
    static void inorder(TreeNode root, List<Integer> list) {
        TreeNode cur = root;
        while (cur != null) {
            TreeNode left = cur.left;
            if (left == null) {
                list.add(cur.val);
                cur = cur.right;
            } else {
                while (left.right != null && left.right != cur) {
                    left = left.right;
                }
                
                if (left.right == null) {
                    left.right = cur;
                    cur = cur.left;
                } else {
                    left.right = null;
                    list.add(cur.val);
                    cur = cur.right;
                }
            }
        }
    }
}
