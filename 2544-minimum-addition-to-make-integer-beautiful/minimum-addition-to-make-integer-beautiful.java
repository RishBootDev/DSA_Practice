class Solution {
  public long makeIntegerBeautiful(long n, int target) {
    if (digitSum(n) <= target) return 0;

    long add = 0;
    long pow = 1;

    while (digitSum(n) > target) {
      long digit = (n / pow) % 10;
      long inc = 10 - digit;
      add += inc * pow;
      n += inc * pow;
      pow *= 10;
    }
    return add;
  }

  private int digitSum(long n) {
    int sum = 0;
    while (n > 0) {
      sum += n % 10;
      n /= 10;
    }
    return sum;
  }
}