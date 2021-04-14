package tree.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {
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
        preorder(root, list);
        System.out.println(list);
        
        list.clear();
        
        preorder2(root, list);
        System.out.println(list);
    }
    
    private static void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
    
    public static void preorder2(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        
        Deque<TreeNode> stack = new LinkedList<>();
        
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            while (root != null) {
                res.add(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                }
                
                root = root.left;
            }
        }
    }
}
