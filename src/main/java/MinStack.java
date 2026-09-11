import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public MinStack() {
        this.stack = new Stack<>();
        this.min = new Stack<>();
    }

    public void push(int value) {
        min.push(Math.min(value, min.peek()));
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
