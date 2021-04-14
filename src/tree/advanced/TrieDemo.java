package tree.advanced;

public class TrieDemo {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("abcd");
    
        System.out.println(trie.contains("abc"));
        System.out.println(trie.contains("ab"));
        System.out.println(trie.contains("abcd"));
        
        trie.insert("zsb");
        dfs(trie.root, new StringBuilder());
    }
    
    private static void dfs(Trie.Node root, StringBuilder sb) {
        if (root == null) {
            return;
        }
    
        if (root.isWord) {
            System.out.println(sb);
        }
    
        for (int i = 0; i < root.next.length; i++) {
            if (root.next[i] != null) {
                sb.append((char) ('a' + i));
                dfs(root.next[i], sb);
                sb.setLength(sb.length() - 1);
            }
        }
    }
}

class Trie {
    
    static class Node {
        boolean isWord;
        Node[] next;
        
        public Node() {
            next = new Node[26];
        }
    }
    
    Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String s) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (cur.next[idx] == null) {
                cur.next[idx] = new Node();
            }
            
            cur = cur.next[idx];
        }
        
        cur.isWord = true;
    }
    
    public boolean contains(String s) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (cur.next[idx] == null) {
                return false;
            }
            
            cur = cur.next[idx];
        }
        
        return cur.isWord;
    }
}
