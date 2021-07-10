package tree.advanced;

public class BST<Integer> {
    private class Node {
        public int key;
        public Node left, right;
        
        public Node(int key) {
            this.key = key;
        }
    }
    
    private Node root;
    private int size;
    
    public BST() {
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void add(int key) {
        root = add(root, key);
    }
    
    private Node add(Node node, int key) {
        if (node == null) {
            size++;
            return new Node(key);
        }
        
        if (key < node.key) {
            node.left = add(node.left, key);
        } else if (key > node.key) {
            node.right = add(node.right, key);
        }
        
        return node;
    }
    
    public boolean contains(int key) {
        return getNode(root, key) != null;
    }
    
    private Node getNode(Node node, int key) {
        if (node == null || node.key == key) {
            return node;
        }
        
        if (key < node.key) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }
    
    private Node minimum(Node node) {
        if (node == null) {
            return null;
        }
        
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
    private Node removeMin(Node node) {
        if (node == null) {
            return null;
        }
        
        if (node.left == null) {
            size--;
            return node.right;
        }
        
        node.left = removeMin(node.left);
        return node;
    }
    
    public void remove(int key) {
        root = remove(root, key);
    }
    
    private Node remove(Node node, int key) {
        if (node == null) {
            return null;
        }
            size--;
        if (key < node.key) {
            node.left = remove(node.left, key);
            return node;
        } else if (key > node.key) {
            node.right = remove(node.right, key);
            return node;
        }
        
        if (node.left == null) {
            return node.right;
        } else if (node.right == null) {
            return node.left;
        } else {
            node.key = minimum(node.right).key;
            return node = removeMin(node.right);
        }
    }
}
