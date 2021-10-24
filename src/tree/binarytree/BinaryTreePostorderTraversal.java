package tree.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {
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
        postorder(root, list);
        System.out.println(list);
        
        list.clear();
        
        postorder2(root, list);
        System.out.println(list);
    }
    
    static void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }
    
    static void postorder2(TreeNode root, List<Integer> list) {
        Deque<TreeNode> stk = new LinkedList<>();
        while (!stk.isEmpty() || root != null) {
            while (root != null) {
                stk.push(root);
                if (root.left != null) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            
            root = stk.pop();
            list.add(root.val);
            if (!stk.isEmpty() && root == stk.peek().left) {
                root = stk.peek().right;
            } else {
                root = null;
            }
        }
    }
}
