public class FormArraysByConcateningSubarraysOfAnotherArray {


    public boolean canChoose(int[][] groups, int[] nums) {
        StringBuilder sb = new StringBuilder(" ");
        for (int c : nums) sb.append(c).append(" ");

        String temp = sb.toString();
        int start = 0;

        for (int i = 0; i < groups.length; i++) {
            StringBuilder first = new StringBuilder(" ");

            for (int c : groups[i]) first.append(c).append(" ");

            String group = first.toString();
            int a = temp.indexOf(group, start);

            if (a == -1) return false;

            start = a + group.length() - 1;
        }

        return true;
    }
}
