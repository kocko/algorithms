package topcoder.contests701_800.srm772;

public class PermutationAndMultiplication {

  public int multiplyAndCount(int ones, int zeroes) {
    if (ones == 1) return 1;
    if (zeroes == 0) return ones;

    char[] a = getFirst(ones, zeroes);
    char[] b = getLast(ones, zeroes);
    return sum(a, b);
  }

  private char[] getFirst(int ones, int zeroes) {
    StringBuilder result = new StringBuilder();
    if (ones > 1) {
      for (int i = 0; i < ones - 2; i++) {
        result.append(1);
      }
      if (ones > 2) {
        result.append(0);
      }
      result.append(1);
      for (int i = 0; i < ones - 2; i++) {
        result.append(0);
      }
      result.append(1);
      for (int i = 0; i < zeroes; i++) {
        result.append(0);
      }
    }
    return result.toString().toCharArray();
  }

  private char[] getLast(int ones, int zeroes) {
    int n = ones + zeroes;
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < ones; i++) {
      result.append(1);
    }
    for (int i = 0; i < zeroes; i++) {
      result.append(0);
    }
    for (int i = 0; i < n - 1; i++) {
      result.append(0);
    }
    return result.toString().toCharArray();
  }

  private int sum(char[] a, char[] b) {
    int result = 0;
    int carry = 0;
    int i = a.length - 1, j = b.length - 1;
    while (i >= 0 || j >= 0) {
      int x = i >= 0 ? (a[i] - '0') : 0;
      int y = j >= 0 ? (b[j] - '0') : 0;
      int sum = carry + (x + y);
      if (sum % 2 == 1) {
        result++;
      }
      carry = (sum >> 1);
      i--;
      j--;
    }
    if (carry > 0) result++;
    return result;
  }

}
