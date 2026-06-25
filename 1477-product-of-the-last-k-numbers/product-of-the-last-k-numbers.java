class ProductOfNumbers {

    List<Integer> list;
    public ProductOfNumbers() {
        this.list = new ArrayList<>();
    }

    public void add(int num) {
        this.list.add(num);
    }

    public int getProduct(int k) {
        
        int prod = 1;
        int i = list.size() -1 ;
        while(k-->0) {
          prod *= list.get(i);
          i--;
        }
        return prod;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */