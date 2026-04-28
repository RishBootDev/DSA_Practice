import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ThroneInheritance {

    private Node king;
    private List<String> order;

    static class Node{
        String name;
        List<Node> children;
        private boolean alive;

        public Node(String name, List<Node> child) {
            this.name = name;
            this.children = child;
            this.alive = true;
        }
    }

    public ThroneInheritance(String kingName) {
        this.king = new Node(kingName, new ArrayList<>());
        this.order = new ArrayList<>();
    }

    public void birth(String parentName, String childName) {
        finder(this.king, parentName, childName);
    }

    public void finder(Node king, String parentName, String childName) {
        if(king == null) return;
        if(Objects.equals(king.name, parentName)) {
            List<Node> children = king.children;
            children.add(new Node(childName, new ArrayList<>()));
        }
        for(Node temp : king.children) {
            finder(temp, parentName, childName);
        }
    }

    public void death(String name) {
        del(this.king, name);
    }

    public void del(Node king, String name) {
        if(king.name.equals(name)) {
            king.alive = false;
        }
        for(Node children : king.children) {
            del(children ,name);
        }
    }

    public List<String> getInheritanceOrder() {
        order.clear();
        helper(king);

        return order;
    }

    public void helper(Node king) {
        if(king.alive)
            this.order.add(king.name);

        for(Node children : king.children){
            helper(children);
        }
    }
}
