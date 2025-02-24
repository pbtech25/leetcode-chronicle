class Solution {
    private List<List<Integer>> graph;
    private int[] parent;
    private int[] bobDist;
    private int n;
    private int[] amount;  // Added amount as class field
    
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        this.amount = amount;  // Store amount array
        n = amount.length;
        // Build adjacency list representation of the tree
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // Find parent of each node and path from bob to root
        parent = new int[n];
        bobDist = new int[n];
        Arrays.fill(bobDist, n);
        dfsParent(0, -1);
        
        // Calculate Bob's distance to each node in his path
        int curr = bob;
        int dist = 0;
        while (curr != -1) {
            bobDist[curr] = dist;
            curr = parent[curr];
            dist++;
        }
        
        // DFS to find Alice's maximum profit
        return dfsAlice(0, -1, 0);
    }
    
    // DFS to build parent array
    private void dfsParent(int node, int prev) {
        parent[node] = prev;
        for (int next : graph.get(node)) {
            if (next != prev) {
                dfsParent(next, node);
            }
        }
    }
    
    // DFS to find Alice's maximum profit
    private int dfsAlice(int node, int prev, int aliceDist) {
        // Calculate current node's contribution to profit
        int profit;
        if (aliceDist < bobDist[node]) {
            // Alice reaches before Bob
            profit = amount[node];
        } else if (aliceDist == bobDist[node]) {
            // Alice and Bob reach simultaneously
            profit = amount[node] / 2;
        } else {
            // Bob reaches before Alice
            profit = 0;
        }
        
        // Check if it's a leaf node
        boolean isLeaf = true;
        int maxChildProfit = Integer.MIN_VALUE;
        
        // Recurse for all children
        for (int next : graph.get(node)) {
            if (next != prev) {
                isLeaf = false;
                maxChildProfit = Math.max(maxChildProfit, 
                    dfsAlice(next, node, aliceDist + 1));
            }
        }
        
        // Return total profit
        return profit + (isLeaf ? 0 : maxChildProfit);
    }
}
