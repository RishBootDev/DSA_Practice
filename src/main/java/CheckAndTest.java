public class CheckAndTest {

    public static void main(String[] args) {
        String str = "Rishabh";
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(count % 2 == 0 && count != 0) {
                sb.append('@');
            }
            sb.append(str.charAt(i));
            count++;
        }

        System.out.println(sb);
    }


}
