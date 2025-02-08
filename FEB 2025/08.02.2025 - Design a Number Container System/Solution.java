class NumberContainers {
    // Map to store index -> number mapping
    private Map<Integer, Integer> indexToNum;
    // Map to store number -> TreeSet of indices mapping
    private Map<Integer, TreeSet<Integer>> numToIndices;
    
    public NumberContainers() {
        indexToNum = new HashMap<>();
        numToIndices = new HashMap<>();
    }
    
    public void change(int index, int number) {
        // If index already contains a number, remove it from the old number's TreeSet
        if (indexToNum.containsKey(index)) {
            int oldNum = indexToNum.get(index);
            numToIndices.get(oldNum).remove(index);
            // If TreeSet becomes empty, remove the entry
            if (numToIndices.get(oldNum).isEmpty()) {
                numToIndices.remove(oldNum);
            }
        }
        
        // Update index -> number mapping
        indexToNum.put(index, number);
        
        // Update number -> indices mapping
        numToIndices.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }
    
    public int find(int number) {
        // If number exists in the system, return its smallest index
        if (numToIndices.containsKey(number) && !numToIndices.get(number).isEmpty()) {
            return numToIndices.get(number).first();
        }
        return -1;
    }
}