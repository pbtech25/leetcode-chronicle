class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int prefixZeros[] = new int[n];
        prefixZeros[0] = (s.charAt(0) == '0') ? 1 : 0;
        for (int i = 1; i < n; i++) {
            prefixZeros[i] = prefixZeros[i - 1] + (s.charAt(i) == '0' ? 1 : 0);
        }

        int[] suffixOnes = new int[n];
        suffixOnes[n - 1] = (s.charAt(n - 1) == '1') ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            suffixOnes[i] = suffixOnes[i + 1] + (s.charAt(i) == '1' ? 1 : 0);
        }

        int maxScore = 0;
        for (int i = 0; i < n - 1; i++) {
            int currentScore = prefixZeros[i] + suffixOnes[i + 1];
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }
}

