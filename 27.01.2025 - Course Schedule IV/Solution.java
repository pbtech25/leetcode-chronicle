class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Create adjacency matrix to represent the graph
        // reachable[i][j] means i is a prerequisite of j
        boolean[][] reachable = new boolean[numCourses][numCourses];
        
        // Initialize direct prerequisites
        for (int[] prereq : prerequisites) {
            reachable[prereq[0]][prereq[1]] = true;
        }
        
        // Floyd-Warshall algorithm to find all indirect prerequisites
        // If k is prerequisite of j and i is prerequisite of k,
        // then i is prerequisite of j
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    reachable[i][j] = reachable[i][j] || 
                                    (reachable[i][k] && reachable[k][j]);
                }
            }
        }
        
        // Answer queries using the computed reachability matrix
        List<Boolean> answer = new ArrayList<>();
        for (int[] query : queries) {
            answer.add(reachable[query[0]][query[1]]);
        }
        
        return answer;
    }
}