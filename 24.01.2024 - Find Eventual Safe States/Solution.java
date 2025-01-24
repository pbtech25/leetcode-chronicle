class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        // 0: unvisited, 1: visiting, 2: safe, 3: unsafe
        int[] state = new int[n];
        List<Integer> safeNodes = new ArrayList<>();
        
        // Check each node
        for (int i = 0; i < n; i++) {
            if (isSafe(graph, i, state)) {
                safeNodes.add(i);
            }
        }
        
        // Sort in ascending order
        Collections.sort(safeNodes);
        return safeNodes;
    }
    
    // DFS to determine if a node is safe
    private boolean isSafe(int[][] graph, int node, int[] state) {
        // If we've already determined the state, return true if safe
        if (state[node] != 0) {
            return state[node] == 2;
        }
        
        // Mark as currently visiting
        state[node] = 1;
        
        // Check all adjacent nodes
        for (int neighbor : graph[node]) {
            // If neighbor is currently being visited or unsafe, this node is unsafe
            if (state[neighbor] == 1 || !isSafe(graph, neighbor, state)) {
                state[node] = 3;
                return false;
            }
        }
        
        // If we've reached here, the node is safe
        state[node] = 2;
        return true;
    }
}