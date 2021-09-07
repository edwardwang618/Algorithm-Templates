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
        
        // inorder(root, list);
        // preorder(root, list);
        postorder(root, list);
        System.out.println(list);
    }
    
    static void preorder(TreeNode root, List<Integer> list) {
        TreeNode cur = root;
        while (cur != null) {
            TreeNode left = cur.left;
            if (left != null) {
                while (left.right != null && left.right != cur) {
                    left = left.right;
                }
                
                if (left.right == null) {
                    left.right = cur;
                    list.add(cur.val);
                    cur = cur.left;
                    continue;
                } else {
                    left.right = null;
                }
            } else {
                list.add(cur.val);
            }
            
            cur = cur.right;
        }
    }
    
    static void inorder(TreeNode root, List<Integer> list) {
        TreeNode cur = root;
        while (cur != null) {
            TreeNode left = cur.left;
            if (left != null) {
                while (left.right != null && left.right != cur) {
                    left = left.right;
                }
                
                if (left.right == null) {
                    left.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    left.right = null;
                }
            }
            
            list.add(cur.val);
            cur = cur.right;
        }
    }
    
    static void postorder(TreeNode root, List<Integer> list) {
        TreeNode cur = root;
        while (cur != null) {
            TreeNode left = cur.left;
            if (left != null) {
                while (left.right != null && left.right != cur) {
                    left = left.right;
                }
                
                if (left.right == null) {
                    left.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    left.right = null;
                    addEdge(cur.left, list);
                }
            }
            
            cur = cur.right;
        }
        
        addEdge(root, list);
    }
    
    static void addEdge(TreeNode cur, List<Integer> list) {
        TreeNode tail = reverse(cur);
        while (tail != null) {
            list.add(tail.val);
            tail = tail.right;
        }
        
        reverse(tail);
    }
    
    static TreeNode reverse(TreeNode head) {
        TreeNode prev = null, tmp = null;
        while (head != null) {
            tmp = head.right;
            head.right = prev;
            prev = head;
            head = tmp;
        }
        
        return prev;
    }
}
