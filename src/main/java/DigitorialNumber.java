public class DigitorialNumber {

    public boolean isDigitorialPermutation(int n) {

        int fact[] = new int[10];

        for (int i = 0; i < fact.length; i++) {
            fact[i] = fact(i);
        }

        String num = String.valueOf(n);
        int sum = 0;
        for (int i = 0; i < num.length(); i++) {
            sum += fact[num.charAt(i)-'0'];
        }

        return sum == n;

    }

    public int fact(int n){

        if(n==1 || n==0 ) return 1;
        return n*fact(n-1);
    }
}
