class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int result[] = new int[n];

        int ballCount = 0;
        int steps = 0;
        for (int i = 0; i < n; i++) {
            result[i] += steps;
            ballCount += boxes.charAt(i) - '0';
            steps += ballCount;
        }

        ballCount = 0; steps = 0;

        for (int i = n - 1; i >= 0; i--) {
            result[i] += steps;
            ballCount += boxes.charAt(i) - '0';
            steps += ballCount;
        }

        return result;
    }
}