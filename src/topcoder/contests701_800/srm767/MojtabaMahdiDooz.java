package topcoder.contests701_800.srm767;

public class MojtabaMahdiDooz {

  public String play(String board) {
    char[] x = board.toCharArray();
    int idx = 0, n = board.length();
    while (true) {
      if (idx + 1 < n) {
        if (x[idx + 1] == '-') {
          x[idx] = '-';
          x[idx + 1] = 'W';
          idx++;
        } else if (idx + 2 < n && x[idx + 2] == '-') {
          x[idx] = '-';
          x[idx + 2] = 'W';
          idx += 2;
        } else break;
      } else break;
    }
    return new String(x);
  }

}
