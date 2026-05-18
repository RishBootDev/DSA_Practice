class Solution {

    public String discountPrices(String sentence, int discount) {

        String[] arr = sentence.split(" ");

        StringBuilder ans = new StringBuilder();
        for (String str : arr) {

            if (isPrice(str)) {
                long price = Long.parseLong(str.substring(1));
                double discountedPrice =
                        price - (price * discount / 100.0);

                ans.append("$")
                   .append(String.format("%.2f", discountedPrice));

            } else {
                ans.append(str);
            }
            ans.append(" ");
        }

        return ans.toString().trim();
    }

    public boolean isPrice(String str) {

        if (str.length() <= 1 || str.charAt(0) != '$') {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {

            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}