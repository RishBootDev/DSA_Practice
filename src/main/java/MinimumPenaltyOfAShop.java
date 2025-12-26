public class MinimumPenaltyOfAShop {
    public int bestClosingTime(String customer) {

        int n = customer.length();

        int preY[] = new int[n];
        int suffN[] = new int[n];

        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (customer.charAt(i) == 'Y') count++;
            preY[i] = count;
        }

        count = 0;
        for (int i = 0; i < n; i++) {
            suffN[i] = count;
            if (customer.charAt(i) == 'N') count++;
        }

        int minPenalty = Integer.MAX_VALUE;
        int idx = 0;

        for (int i = 0; i < n; i++) {
            int penalty = preY[i] + suffN[i];

            if (penalty < minPenalty) {
                minPenalty = penalty;
                idx = i;
            }
        }

        if (count < minPenalty) {
            idx = n;
        }

        return idx;
    }
}
