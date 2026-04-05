import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DesignBrowserHistory {

    private List<String> stack;
    private int curr;

    public DesignBrowserHistory(String homepage) {
        this.stack = new ArrayList<>();
        stack.add(homepage);
        curr = 0;
    }

    public void visit(String url) {
        while (stack.size() > curr + 1) {
            stack.remove(stack.size() - 1);
        }
        stack.add(url);
        curr++;
    }

    public String back(int steps) {
        curr = Math.max(0, curr - steps);
        return stack.get(curr);
    }

    public String forward(int steps) {
        curr = Math.min(stack.size() - 1, curr + steps);
        return stack.get(curr);
    }

}
