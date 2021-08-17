package tree.bbst;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class TreapDemo {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        int size = 10000000;
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt());
        }
        
        System.out.println(Math.log(size) / Math.log(2));
        Treap treap = new Treap(list);
        System.out.println(treap.getHeight());
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
    
    public Treap(Collection<Integer> collection) {
        for (int x : collection) {
            insert(x);
        }
    }
    
    public Treap(int[] A) {
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
                    root = zig(root);
                }
            } else if (key > root.key) {
                root.right = insert(root.right, key);
                if (root.right != null && root.right.val > root.val) {
                    root = zag(root);
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
    
    public int getHeight() {
        return getHeight(root);
    }
    
    private int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}