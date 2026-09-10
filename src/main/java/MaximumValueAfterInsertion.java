public class MaximumValueAfterInsertion {

    public String maxValue(String n, int x) {
        StringBuilder sb = new StringBuilder();
        char ch = (char) (x + '0');

        if (n.charAt(0) != '-') {

            int i = 0;
            for (; i < n.length(); i++) {
                char a = n.charAt(i);
                if (ch > a) {
                    sb.append(ch);
                    break;
                }
                sb.append(a);
            }

            if (i == n.length()) {
                sb.append(ch);
            } else {
                sb.append(n.substring(i));
            }

        } else {

            sb.append('-');

            int i = 1;
            for (; i < n.length(); i++) {
                char a = n.charAt(i);
                if (ch < a) {
                    sb.append(ch);
                    break;
                }
                sb.append(a);
            }

            if (i == n.length()) {
                sb.append(ch);
            } else {
                sb.append(n.substring(i));
            }
        }

        return sb.toString();
    }
}
