package tree.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        System.out.println(list);
        
        list.clear();
        
        inorder2(root, list);
        System.out.println(list);
    }
    
    public static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
    
    public static void inorder2(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        
        Deque<TreeNode> stk = new LinkedList<>();
        while (!stk.isEmpty() || root != null) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
    }
}
