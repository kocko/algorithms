package topcoder.contests601_700.srm658;

public class InfiniteString {

  public String equal(String s, String t) {
    boolean equal = true;
    for (int i = 0; i < Math.max(s.length(), t.length()); i++) {
      char x = i < s.length() ? s.charAt(i) : '?';
      char y = i < t.length() ? t.charAt(i) : '?';
      equal &= x == y;
    }
    return equal ? "Equal" : "Not equal";
  }
  
}
