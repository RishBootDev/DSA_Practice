class FrontMiddleBackQueue {

    ArrayDeque<Integer> first;
    ArrayDeque<Integer> second;

    public FrontMiddleBackQueue() {
        first = new ArrayDeque<>();
        second = new ArrayDeque<>();
    }

    private void balance() {
        if (first.size() > second.size()) {
            second.offerFirst(first.removeLast());
        } else if (second.size() > first.size() + 1) {
            first.offerLast(second.removeFirst());
        }
    }

    public void pushFront(int val) {
        first.offerFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (first.size() == second.size()) {
            second.offerFirst(val);
        } else {
            first.offerLast(val);
        }
        balance();
    }

    public void pushBack(int val) {
        second.offerLast(val);
        balance();
    }

    public int popFront() {
        if (first.isEmpty() && second.isEmpty()) return -1;
        int ans;
        if (!first.isEmpty()) {
            ans = first.removeFirst();
        } else {
            ans = second.removeFirst();
        }
        balance();
        return ans;
    }

    public int popMiddle() {
        if (first.isEmpty() && second.isEmpty()) return -1;

        int ans;
        if (first.size() == second.size()) {
            ans = first.removeLast();
        } else {
            ans = second.removeFirst();
        }
        balance();
        return ans;
    }

    public int popBack() {
        if (first.isEmpty() && second.isEmpty()) return -1;
        int ans = second.removeLast();
        balance();
        return ans;
    }
}