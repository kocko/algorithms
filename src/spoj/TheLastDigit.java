package spoj;

import java.util.*;

public class TheLastDigit {
  
  static int p(int a, int b) {
    int r = 0;
    int[][] x = {{0}, {1}, {2, 4, 8, 6, 2}, {3, 9, 7, 1}, {4, 6}, {5}, {6}, {7, 9, 3, 1}, {8, 4, 2, 6}, {9, 1}};
    if (a == 0) return 0;
    else if (b == 0) return 1;
    else if (a == 1 || a == 5 || a == 6) r = x[a][0];
    else if (a == 2 || a == 3 || a == 7 || a == 8) r = x[a][(b - 1) % 4];
    else if (a == 4 || a == 9) r = x[a][(b & 1) == 1 ? 0 : 1];
    return r;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      System.out.println(p(in.nextInt() % 10, in.nextInt()));
    }
  }
}
