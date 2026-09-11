class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public MinStack() {
        this.stack = new Stack<>();
        this.min = new Stack<>();
    }

    public void push(int value) {
        if(!min.isEmpty())
           min.push(Math.min(value, min.peek()));
        else min.push(value);
        stack.push(value);
    }

    public void pop() {
        min.pop();
        stack.pop();
    }

    public int top() {
       return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */