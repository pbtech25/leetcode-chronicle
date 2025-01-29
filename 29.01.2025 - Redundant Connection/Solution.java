class Solution {
    private int[] parent;
    private int[] rank;
    
    // Initialize the Union-Find data structure
    private void init(int size) {
        parent = new int[size + 1];  // +1 because nodes are 1-based
        rank = new int[size + 1];
        
        // Initially, each node is its own parent
        for (int i = 0; i <= size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    
    // Find the root/parent of a node with path compression
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // Path compression
        }
        return parent[x];
    }
    
    // Union two nodes by rank
    // Returns false if they're already connected (cycle detected)
    private boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX == rootY) {
            return false;  // Cycle detected
        }
        
        // Union by rank to keep the tree balanced
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        
        return true;
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        init(edges.length);
        
        // Process each edge
        for (int[] edge : edges) {
            // If adding this edge creates a cycle, it's our answer
            if (!union(edge[0], edge[1])) {
                return edge;
            }
        }
        
        // This line should never be reached given the problem constraints
        return new int[]{};
    }
}