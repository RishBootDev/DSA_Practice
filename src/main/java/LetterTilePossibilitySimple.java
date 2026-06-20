import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilitySimple {

    public Set<String> set;

    public int numTilePossibilities(String tiles) {
          set = new HashSet<>();
          helper(tiles, 0, new StringBuilder());
          return set.size();
    }

    public void helper(String tiles, int i, StringBuilder curr) {

        if(tiles.length() == i) {
            if(!curr.equals("")) set.add(curr.toString());
            return;
        }

        // take
        curr.append(tiles.charAt(i));
        helper(tiles, i + 1, curr);
        curr.deleteCharAt(curr.length() - 1);

        // not take
        helper(tiles, i + 1, curr);
    }
}
