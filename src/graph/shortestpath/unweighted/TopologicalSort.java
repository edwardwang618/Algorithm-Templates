package graph.shortestpath.unweighted;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        
    }
    
    public static void bfs(Map<Node, List<Node>> graph, List<Integer> res) {
        Map<Node, Integer> indegrees = new HashMap<>();
        for (Map.Entry<Node, List<Node>> entry : graph.entrySet()) {
            for (Node to : entry.getValue()) {
                indegrees.put(to, indegrees.getOrDefault(to, 0) + 1);
            }
        }
        
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        for (Node node : graph.keySet()) {
            if (indegrees.getOrDefault(node, 0) == 0) {
                queue.offer(node);
                visited.add(node);
            }
        }
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            res.add(cur.val);
            
            for (Node next : cur.neighbors) {
                if (visited.contains(next)) {
                    continue;
                }
                
                indegrees.put(next, indegrees.get(next) - 1);
                if (indegrees.get(next) == 0) {
                    queue.offer(next);
                    visited.add(cur);
                }
            }
        }
        
        if (res.size() < graph.size()) {
            throw new RuntimeException("Not a DAG, no topological sort");
        }
    }
}

