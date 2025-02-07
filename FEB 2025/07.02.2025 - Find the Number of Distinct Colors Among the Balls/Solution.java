class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        // Map to store ball to color mapping
        Map<Integer, Integer> ballToColor = new HashMap<>();
        
        // Map to store frequency of each color
        Map<Integer, Integer> colorFreq = new HashMap<>();
        
        int[] result = new int[queries.length];
        int distinctColors = 0;
        
        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int newColor = queries[i][1];
            
            // If ball was previously colored
            if (ballToColor.containsKey(ball)) {
                int oldColor = ballToColor.get(ball);
                // Decrease frequency of old color
                colorFreq.put(oldColor, colorFreq.get(oldColor) - 1);
                // If frequency becomes 0, decrease distinct colors count
                if (colorFreq.get(oldColor) == 0) {
                    distinctColors--;
                    colorFreq.remove(oldColor);
                }
            }
            
            // Add new color
            ballToColor.put(ball, newColor);
            colorFreq.put(newColor, colorFreq.getOrDefault(newColor, 0) + 1);
            // If this is first occurrence of color, increase distinct colors count
            if (colorFreq.get(newColor) == 1) {
                distinctColors++;
            }
            
            result[i] = distinctColors;
        }
        
        return result;
    }
}