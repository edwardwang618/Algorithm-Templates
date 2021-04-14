package graph.shortestpath.unweighted;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int val;
    List<Node> neighbors;
    
    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        return "Node1{" +
                "val=" + val +
                '}';
    }
}
