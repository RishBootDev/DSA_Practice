class Solution {
     public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {

        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < positions.length; i++) {
            pairs.add(new Pair(
                    directions.charAt(i),
                    healths[i],
                    positions[i],
                    i
            ));
        }
        
        pairs.sort((a, b) -> Integer.compare(a.pos, b.pos));
        Stack<Pair> stack = new Stack<>();
        
        for (Pair pair : pairs) {
            if (pair.dir == 'R') {
                stack.push(pair);
            } else {
                while (!stack.isEmpty() && stack.peek().dir == 'R' && pair.health > 0) {

                    Pair top = stack.peek();
                    if (top.health > pair.health) {
                        top.health--;
                        pair.health = 0;
                    }
                    else if (top.health < pair.health) {
                        stack.pop();
                        pair.health--;
                    }
                    else {
                        stack.pop();
                        pair.health = 0;
                    }
                }
                if (pair.health > 0) {
                    stack.push(pair);
                }
            }
        }
        
        List<Pair> survivors = new ArrayList<>(stack);
        survivors.sort((a, b) -> Integer.compare(a.index, b.index));
        List<Integer> ans = new ArrayList<>();

        for (Pair p : survivors) {
            ans.add(p.health);
        }
        return ans;
    }

    static class Pair {
        char dir;
        int health;
        int pos;
        int index;

        public Pair(char dir, int health, int pos, int index) {
            this.dir = dir;
            this.health = health;
            this.pos = pos;
            this.index = index;
        }
    }
}