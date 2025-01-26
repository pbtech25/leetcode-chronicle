class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        
        // Find cycles and build graph
        int[] indegree = new int[n];
        for (int f : favorite) {
            indegree[f]++;
        }
        
        // Queue for removing nodes with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        // Remove nodes with indegree 0
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // Find depth for each node
        int[] depth = new int[n];
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visited[curr] = true;
            int next = favorite[curr];
            
            depth[next] = Math.max(depth[next], depth[curr] + 1);
            
            indegree[next]--;
            if (indegree[next] == 0) {
                queue.offer(next);
            }
        }
        
        // Find cycles and max cycle/chain
        int maxCycleSize = 0;
        int totalChainLength = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // Detect cycle
                List<Integer> cycle = new ArrayList<>();
                int curr = i;
                while (!visited[curr]) {
                    visited[curr] = true;
                    cycle.add(curr);
                    curr = favorite[curr];
                }
                
                // Find cycle starting point 
                int cycleStart = cycle.indexOf(curr);
                int cycleSize = cycle.size() - cycleStart;
                
                // Special handling for 2-person cycle
                if (cycleSize == 2) {
                    int a = cycle.get(cycleStart);
                    int b = favorite[a];
                    totalChainLength += depth[a] + depth[b] + 2;
                } else {
                    maxCycleSize = Math.max(maxCycleSize, cycleSize);
                }
            }
        }
        
        return Math.max(maxCycleSize, totalChainLength);
    }
}