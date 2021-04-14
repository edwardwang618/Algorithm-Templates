package graph.shortestpath.weighted;

import java.util.*;

public class SPFA {
    public static void main(String[] args) {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
    
        n0.neighbors.addAll(Arrays.asList(
                new Pair(1, n1),
                new Pair(2, n2),
                new Pair(4, n3)));
        n1.neighbors.addAll(Arrays.asList(
                new Pair(1, n0),
                new Pair(3, n3)));
        n4.neighbors.addAll(Arrays.asList(
                new Pair(-5, n5),
                new Pair(2, n6),
                new Pair(3, n3)));
        n3.neighbors.addAll(Arrays.asList(new Pair(1, n4)));
    
        Map<Node, Integer> dist = new HashMap<>();
        
        spfa(n0, dist);
    
        System.out.println(dist);
    }
    
    public static void spfa(Node cur, Map<Node, Integer> dist) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(cur);
        Set<Node> used = new HashSet<>();
        used.add(cur);
        
        dist.put(cur, 0);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            used.remove(cur);
    
            for (Pair pair : cur.neighbors) {
                Node next = pair.node;
                int d = pair.dist;
                if (dist.getOrDefault(next, Integer.MAX_VALUE) > dist.get(cur) + d) {
                    dist.put(next, dist.get(cur) + d);
                    if (!used.contains(next)) {
                        queue.offer(next);
                        used.add(next);
                    }
                }
            }
        }
    }
}
