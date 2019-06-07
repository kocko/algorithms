package topcoder.contests601_700.srm658;

public class InfiniteString {

  public String equal(String s, String t) {
    int a = s.length(), b = t.length();
    StringBuilder x = new StringBuilder();
    StringBuilder y = new StringBuilder();
    for (int i = 0; i < b; i++) x.append(s);
    for (int i = 0; i < a; i++) y.append(t);
    return x.toString().equals(y.toString()) ? "Equal" : "Not equal";
  }

}
