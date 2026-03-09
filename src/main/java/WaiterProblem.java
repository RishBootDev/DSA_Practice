import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WaiterProblem {

        public static List<Integer> waiter(List<Integer> number, int q) {

            List<Integer> primes = getPrimes();
            List<Integer> ans = new ArrayList<>();

            int k = 0;

            while (q-- > 0) {

                List<Integer> next = new ArrayList<>();
                Stack<Integer> divisible = new Stack<>();

                for (int i = number.size() - 1; i >= 0; i--) {
                    int x = number.get(i);

                    if (x % primes.get(k) == 0) {
                        divisible.push(x);
                    } else {
                        next.add(x);
                    }
                }

                while (!divisible.isEmpty()) {
                    ans.add(divisible.pop());
                }

                number = next;
                k++;
            }

            for (int i = number.size() - 1; i >= 0; i--) {
                ans.add(number.get(i));
            }

            return ans;
        }

        public static List<Integer> getPrimes() {

            List<Integer> primes = new ArrayList<>();
            int num = 2;

            while (primes.size() < 1200) {

                boolean isPrime = true;

                for (int i = 2; i * i <= num; i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    primes.add(num);
                }

                num++;
            }

            return primes;
        }


}
