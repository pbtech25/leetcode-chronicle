class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        // If strings are equal, return true
        if (s1.equals(s2)) {
            return true;
        }

        // If lengths are not equal, return false
        if (s1.length() != s2.length()) {
            return false;
        }

        // Find the differing positions
        List<Integer> diff = new ArrayList<>();

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff.add(i);
            }

            // If more than 2 positions differ, return false
            if (diff.size() > 2) {
                return false;
            }
        }

        // If only one position differs, we can't make them equal with one swap
        if (diff.size() == 1) {
            return false;
        }

        // If two positions differ, check if swapping would make strings equal
        if (diff.size() == 2) {
            return s1.charAt(diff.get(0)) == s2.charAt(diff.get(1)) &&
                    s1.charAt(diff.get(1)) == s2.charAt(diff.get(0));
        }

        return true;
    }
}