package topcoder.contests601_700.srm604;

public class PowerOfThree {

  public String ableToGet(int x, int y) {
    if (x == 0 && y == 0) return "Possible";
    String a = balancedTernary(x), b = balancedTernary(y);
    int i = a.length() - 1, j = b.length() - 1;
    boolean possible = true;
    while (i >= 0 || j >= 0) {
      int p = i >= 0 ? a.charAt(i) - '0' : 0;
      int q = j >= 0 ? b.charAt(j) - '0' : 0;
      possible &= (p == 0 ^ q == 0);
      i--;
      j--;
    }
    return possible ? "Possible" : "Impossible";
  }

  private String ternary(int x) {
    if (x == 0) return "0";
    StringBuilder result = new StringBuilder();
    while (x > 0) {
      result.append(x % 3);
      x /= 3;
    }
    return result.toString();
  }

  private String balancedTernary(int x) {
    String ternary = ternary(Math.abs(x));
    StringBuilder balanced = new StringBuilder();
    int carry = 0;
    for (int i = 0; i < ternary.length(); i++) {
      char c = ternary.charAt(i);
      int value = (c - '0') + carry;
      carry = value / 3;
      value %= 3;
      if (value <= 1) {
        balanced.append(value);
      } else {
        balanced.append('Z');
        carry++;
      }
    }
    if (carry > 0) {
      balanced.append(carry);
    }
    if (x < 0) {
      for (int i = 0; i < balanced.length(); i++) {
        if (balanced.charAt(i) == 'Z') {
          balanced.setCharAt(i, '1');
        } else if (balanced.charAt(i) == '1') {
          balanced.setCharAt(i, 'Z');
        }
      }
    }
    return balanced.reverse().toString();
  }

}
