import java.util.List;
import java.util.stream.Collectors;

public class Dota2Senate {

    public String predictPartyVictory(String senate) {

        Node head = buildList(senate.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList()));

        int radiant = 0;
        int dire = 0;

        for (char ch : senate.toCharArray()) {
            if (ch == 'R') {
                radiant++;
            } else {
                dire++;
            }
        }
        Node current = head;
        while (radiant > 0 && dire > 0) {

            Node opponent = current.next;
            while (opponent.data == current.data) {
                opponent = opponent.next;
            }
            if (opponent.data == 'R') {
                radiant--;
            } else {
                dire--;
            }
            opponent.prev.next = opponent.next;
            opponent.next.prev = opponent.prev;
            if (opponent == head) {
                head = opponent.next;
            }
            current = current.next;
        }
        return radiant > 0 ? "Radiant" : "Dire";
    }

    public Node buildList(List<Character> senate) {

        Node head = new Node(senate.getFirst());
        Node temp = head;
        for (int i = 1; i < senate.size(); i++) {

            Node newNode = new Node(senate.get(i));
            temp.next = newNode;
            newNode.prev = temp;
            temp = newNode;
        }
        temp.next = head;
        head.prev = temp;

        return head;
    }

    static class Node {

        char data;
        Node prev;
        Node next;

        public Node(char data) {
            this.data = data;
        }
    }
}