package graph.search;

import java.util.*;

public class GraphBFS {
    public static void main(String[] args) {
        Node n0 = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        Node n5 = new Node(6);
        Node n6 = new Node(7);
        
        n0.neighbors.addAll(Arrays.asList(n1, n2, n3));
        n1.neighbors.addAll(Arrays.asList(n0, n3, n5));
        n5.neighbors.addAll(Arrays.asList(n6, n4));
        
        List<Integer> list = new ArrayList<>();
        bfs(n0, list);
        System.out.println(list);
    }
    
    public static void bfs(Node cur, List<Integer> res) {
        if (cur == null) {
            return;
        }
        
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(cur);
        visited.add(cur);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                res.add(cur.val);
                
                for (Node next : cur.neighbors) {
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
    }
}
