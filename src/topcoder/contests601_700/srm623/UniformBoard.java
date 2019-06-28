package topcoder.contests601_700.srm623;

public class UniformBoard {

  public int getBoard(String[] board, int k) {
    int n = board.length;

    int[][] apples = new int[n + 1][n + 1], pears = new int[n + 1][n + 1], empty = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        int[][] prefix;
        char ch = board[i - 1].charAt(j - 1);
        if (ch == '.') {
          prefix = empty;
        } else if (ch == 'A') {
          prefix = apples;
        } else {
          prefix = pears;
        }
        for (int[][] px : new int[][][]{apples, pears, empty}) {
          px[i][j] = px[i - 1][j] + px[i][j - 1] - px[i - 1][j - 1];
        }
        prefix[i][j]++;
      }
    }
    int result = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        for (int l = i; l <= n; l++) {
          for (int m = j; m <= n; m++) {
            int moves = 0;
            int a = apples[l][m] - apples[i - 1][m] - apples[l][j - 1] + apples[i - 1][j - 1];
            int e = empty[l][m] - empty[i - 1][m] - empty[l][j - 1] + empty[i - 1][j - 1];
            int p = pears[l][m] - pears[i - 1][m] - pears[l][j - 1] + pears[i - 1][j - 1];
            int outsideEmpty = empty[n][n] - e;
            int outsideApples = apples[n][n] - a;
            while (e > 0 && outsideApples > 0) {
              moves++;
              e--;
              outsideEmpty++;
              outsideApples--;
              a++;
            }
            if (outsideEmpty > 0) {
              while (p > 0 && outsideApples > 0) {
                moves += 2;
                p--;
                a++;
                outsideApples--;
              }
            }
            int area = (l - i + 1) * (m - j + 1);
            if (a == area && moves <= k) {
              result = Math.max(area, result);
            }
          }
        }
      }
    }
    return result;
  }

}
