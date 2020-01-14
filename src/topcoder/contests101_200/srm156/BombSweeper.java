package topcoder.contests101_200.srm156;

public class BombSweeper {
  public double winPercentage(String[] board) {
    int n = board.length, m = board[0].length();
    char[][] grid = new char[n][m];
    for (int i = 0; i < n; i++) {
      grid[i] = board[i].toCharArray();
    }
    final int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    int good = 0, bombs = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 'B') {
          bombs++;
        } else {
          boolean safe = true;
          for (int[] d : dir) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < n && y >= 0 && y < m) {
              safe &= grid[x][y] == '.';
            }
          }
          if (safe) {
            good++;
          }
        }
      }
    }
    return good * 100. / (good + bombs);
  }

}
