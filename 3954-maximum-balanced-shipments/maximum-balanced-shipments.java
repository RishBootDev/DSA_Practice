class Solution {
    
    public int maxBalancedShipments(int[] weight) {

        Stack<Integer> stack = new Stack<>();
        
        int count = 0;
        for (int i = 0; i < weight.length; i++) {
            
            if(stack.isEmpty() || weight[i] > stack.peek()){
                stack.push(weight[i]);
            }else if (weight[i] < stack.peek()) {
                stack.clear();
                count++;
            }
        }
        return count;
        
    }
}

//2 5 1
//4 3
