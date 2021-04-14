package graph.shortestpath.unweighted;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        
        n0.neighbors.addAll(Arrays.asList(n1, n2, n3));
        n1.neighbors.addAll(Arrays.asList(n0, n3, n5));
        n5.neighbors.addAll(Arrays.asList(n6, n4));
        n4.neighbors.addAll(Arrays.asList(n0, n2, n4));
        
        Map<Node, Integer> dist = new HashMap<>();
        bfs(n0, dist);
        System.out.println(dist);
    }
    
    public static void bfs(Node cur, Map<Node, Integer> dist) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(cur);
        dist.put(cur, 0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                for (Node next : cur.neighbors) {
                    if (!dist.containsKey(next)) {
                        dist.put(next, dist.get(cur) + 1);
                        queue.offer(next);
                    }
                }
            }
        }
    }
}
