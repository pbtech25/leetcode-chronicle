class Solution {
    public int magnificentSets(int n, int[][] edges) {
        // Create adjacency list representation of the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // Find connected components using DFS
        boolean[] visited = new boolean[n + 1];
        List<List<Integer>> components = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, graph, visited, component);
                components.add(component);
            }
        }
        
        int result = 0;
        // Process each component separately
        for (List<Integer> component : components) {
            int maxGroups = -1;
            // Try each node in the component as starting point
            for (int startNode : component) {
                int groups = bfs(startNode, graph, n);
                maxGroups = Math.max(maxGroups, groups);
            }
            // If any component is impossible, return -1
            if (maxGroups == -1) {
                return -1;
            }
            result += maxGroups;
        }
        
        return result;
    }
    
    // DFS to find connected components
    private void dfs(int node, List<List<Integer>> graph, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, component);
            }
        }
    }
    
    // BFS to find maximum number of groups possible starting from a node
    private int bfs(int start, List<List<Integer>> graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> groupNumber = new HashMap<>();
        queue.offer(start);
        groupNumber.put(start, 1);
        int maxGroup = 1;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int currGroup = groupNumber.get(curr);
            
            for (int neighbor : graph.get(curr)) {
                if (!groupNumber.containsKey(neighbor)) {
                    groupNumber.put(neighbor, currGroup + 1);
                    maxGroup = Math.max(maxGroup, currGroup + 1);
                    queue.offer(neighbor);
                } else if (Math.abs(groupNumber.get(neighbor) - currGroup) != 1) {
                    return -1;
                }
            }
        }
        
        return maxGroup;
    }
}