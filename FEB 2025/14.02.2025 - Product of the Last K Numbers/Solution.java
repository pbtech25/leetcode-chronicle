class ProductOfNumbers {
    private List<Integer> products;
    
    public ProductOfNumbers() {
        products = new ArrayList<>();
        // Add 1 as the first element to handle edge cases
        products.add(1);
    }
    
    public void add(int num) {
        if (num == 0) {
            // If number is 0, reset the list since any product including 0 will be 0
            products = new ArrayList<>();
            products.add(1);
        } else {
            // Multiply the last product with current number to maintain prefix products
            products.add(products.get(products.size() - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        int n = products.size();
        // If k is larger than our current list (after removing zeros), return 0
        if (k >= n) {
            return 0;
        }
        // Return the product of last k numbers by dividing current product by
        // product k positions before
        return products.get(n - 1) / products.get(n - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */