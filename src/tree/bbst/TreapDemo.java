package tree.bbst;

import java.util.Random;

public class TreapDemo {
    public static void main(String[] args) {
        int[] A = {1, 3, 6, 10, -1, -1};
        Treap treap = new Treap(A);
        System.out.println(treap.getKeyByRank(1));
        System.out.println(treap.getKeyByRank(2));
        
        System.out.println(treap.getKeyByRank(3));
        
        treap.insert(11);
        treap.insert(12);
    
        System.out.println(treap.getKeyByRank(1));
        System.out.println(treap.getKeyByRank(6));
        
        treap.remove(-1);
        treap.remove(-1);
        System.out.println(treap.getKeyByRank(1));
        System.out.println(treap.getKeyByRank(6));
    }
}

class Treap {
    static class Node {
        static private final Random random = new Random();
        private final int val;
        int key;
        int cnt, size;
        Node left, right;
        
        public Node(int key, int cnt, int size) {
            this.key = key;
            this.val = random.nextInt();
            this.cnt = cnt;
            this.size = size;
        }
    }
    
    private Node root;
    
    public Treap() {
    }
    
    public Treap(int[] A) {
        this();
        for (int x : A) {
            insert(x);
        }
    }
    
    public void insert(int key) {
        root = insert(root, key);
    }
    
    private Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key, 1, 1);
        } else {
            if (key < root.key) {
                root.left = insert(root.left, key);
                if (root.left != null && root.left.val > root.val) {
                    return zig(root);
                }
            } else if (key > root.key) {
                root.right = insert(root.right, key);
                if (root.right != null && root.right.val > root.val) {
                    return zag(root);
                }
            } else {
                root.cnt++;
            }
            
            pushup(root);
            return root;
        }
    }
    
    public void remove(int key) {
        root = remove(root, key);
    }
    
    private Node remove(Node root, int key) {
        if (root == null) {
            return null;
        }
        
        if (key < root.key) {
            root.left = remove(root.left, key);
        } else if (key > root.key) {
            root.right = remove(root.right, key);
        } else {
            if (root.cnt > 1) {
                root.cnt--;
            } else {
                if (root.left == null && root.right == null) {
                    return null;
                }
                
                if (root.right == null || (root.left != null && root.left.val >= root.right.val)) {
                    root = zig(root);
                    root.right = remove(root.right, key);
                } else {
                    root = zag(root);
                    root.left = remove(root.left, key);
                }
            }
        }
        
        pushup(root);
        return root;
    }
    
    public int getKeyByRank(int rank) {
        return getKeyByRank(root, rank);
    }
    
    private int getKeyByRank(Node root, int rank) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        
        int leftSize = 0;
        if (root.left != null) {
            leftSize = root.left.size;
        }
        
        if (leftSize >= rank) {
            return getKeyByRank(root.left, rank);
        } else if (leftSize + root.cnt >= rank) {
            return root.key;
        } else {
            return getKeyByRank(root.right, rank - leftSize - root.cnt);
        }
    }
    
    public int size() {
        return root.size;
    }
    
    public Node zig(Node node) {
        Node p = node, q = node.left;
        p.left = q.right;
        q.right = p;
        pushup(p);
        return q;
    }
    
    public Node zag(Node node) {
        Node p = node, q = node.right;
        p.right = q.left;
        q.left = p;
        pushup(p);
        return q;
    }
    
    public void pushup(Node node) {
        node.size = node.cnt;
        if (node.left != null) {
            node.size += node.left.size;
        }
        if (node.right != null) {
            node.size += node.right.size;
        }
    }
}