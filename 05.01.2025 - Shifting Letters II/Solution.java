class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        long[] diff = new long[n + 1];
        
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            int value = direction == 1 ? 1 : -1;
            diff[start] += value;
            diff[end + 1] -= value;
        }
        
        StringBuilder result = new StringBuilder();
        long currentShift = 0;
        
        for (int i = 0; i < n; i++) {
            currentShift += diff[i];
            char c = s.charAt(i);
            long newPos = ((c - 'a') + currentShift % 26 + 26) % 26;
            result.append((char)('a' + newPos));
        }
        
        return result.toString();
    }
}
