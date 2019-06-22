package topcoder.contests701_800.srm761;

import java.util.ArrayList;
import java.util.List;

public class Pickaxe {

  private class DisjointSet {
    private int[] root, size;

    private DisjointSet(int n) {
      root = new int[n];
      size = new int[n];
      for (int i = 0; i < n; i++) {
        root[i] = i;
        size[i] = 1;
      }
    }

    private int root(int x) {
      return x == root[x] ? x : (root[x] = root(root[x]));
    }

    private boolean join(int a, int b) {
      int x = root(a), y = root(b);
      if (x != y) {
        if (size[x] < size[y]) y = x ^ y ^ (x = y);
        root[y] = x;
        size[x] += size[y];
        return true;
      }
      return false;
    }
  }

  public int countWalls(String[] maze) {
    int n = maze.length, m = maze[0].length();
    char[][] grid = new char[n][m];
    for (int i = 0; i < n; i++) {
      grid[i] = maze[i].toCharArray();
    }
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    DisjointSet dsu = new DisjointSet(n * m);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == '.') {
          int index = i * m + j;
          for (int[] d : dir) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == '.') {
              int idx = x * m + y;
              dsu.join(index, idx);
            }
          }
        }
      }
    }
    int first = dsu.root(0), second = dsu.root(n * m - 1);
    int result = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == '#') {
          List<Integer> neighbours = new ArrayList<>();
          for (int[] d : dir) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == '.') {
              neighbours.add(x * m + y);
            }
          }
          int s = neighbours.size();
          if (s >= 2) {
            out: for (int k = 0; k < s; k++) {
              for (int l = k + 1; l < s; l++) {
                int n1 = neighbours.get(k), n2 = neighbours.get(l);
                if ((dsu.root(n1) == first && dsu.root(n2) == second) || (dsu.root(n2) == first && dsu.root(n1) == second)) {
                  result++;
                  break out;
                }
              }
            }
          }
        }
      }
    }
    
    return result;
  }
}
