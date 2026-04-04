public class DecodeTheSlantedCipherText {

        public static String decodeCiphertext(String encodedText, int rows) {

            if (rows == 0 || encodedText.length() == 0) return "";

            int cols = encodedText.length() / rows;
            String[] str = new String[rows];

            int index = 0;
            for (int i = 0; i < rows; i++) {
                str[i] = encodedText.substring(index, index + cols);
                index += cols;
            }

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < cols; j++) {
                int col = j;
                for (int i = 0; i < rows && col < cols; i++) {
                    sb.append(str[i].charAt(col));
                    col++;
                }
            }

            while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }

            return sb.toString();
        }

}
