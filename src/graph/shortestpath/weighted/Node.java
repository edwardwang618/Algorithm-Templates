package graph.shortestpath.weighted;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int val;
    List<Pair> neighbors;
    
    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}

