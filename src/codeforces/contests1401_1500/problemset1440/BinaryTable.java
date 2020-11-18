package codeforces.contests1401_1500.problemset1440;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BinaryTable implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      int[][] x = new int[n][m];
      for (int i = 0; i < n; i++) {
        String next = in.next();
        for (int j = 0; j < m; j++) {
          x[i][j] = next.charAt(j) - '0';
        }
      }
      List<int[]> result = new ArrayList<>();
      for (int row = 0; row < n - 2; row++) {
        for (int col = 1; col < m; col++) {
          if (x[row][col - 1] == 1 || x[row][col] == 1) {
            int[] flip = new int[6];
            int idx = 0;
            if (x[row][col - 1] == 1) {
              flip[idx++] = row;
              flip[idx++] = col - 1;
              x[row][col - 1] ^= 1;
            }
            if (x[row][col] == 1) {
              flip[idx++] = row;
              flip[idx++] = col;
              x[row][col] ^= 1;
            }
            for (int[] cell : new int[][]{new int[]{row + 1, col}, new int[]{row + 1, col - 1}}) {
              if (idx < 6) {
                flip[idx++] = cell[0];
                flip[idx++] = cell[1];
                x[cell[0]][cell[1]] ^= 1;
              }
            }
            result.add(flip);
          }
        }
      }
      for (int col = 0; col < m - 2; col++) {
        if (x[n - 2][col] == 1 || x[n - 1][col] == 1) {
          int[] flip = new int[6];
          int idx = 0;
          for (int row = n - 2; row < n; row++) {
            if (x[row][col] == 1) {
              flip[idx++] = row;
              flip[idx++] = col;
              x[row][col] ^= 1;
            }
          }
          for (int[] cell : new int[][]{new int[]{n - 2, col + 1}, new int[]{n - 1, col + 1}}) {
            if (idx < 6) {
              flip[idx++] = cell[0];
              flip[idx++] = cell[1];
              x[cell[0]][cell[1]] ^= 1;
            }
          }
          result.add(flip);
        }
      }
      result.addAll(solveSquare(x));
      print(result);
    }
  }

  private List<int[]> solveSquare(int[][] x) {
    int n = x.length, m = x[0].length;
    int count = x[n - 2][m - 2] + x[n - 2][m - 1] + x[n - 1][m - 2] + x[n - 1][m - 1];
    if (count == 0) {
      return Collections.emptyList();
    } else if (count == 1) {
      return solve1(x);
    } else if (count == 2) {
      return solve2(x);
    } else if (count == 3) {
      return solve3(x);
    } else {
      return solve4(x);
    }
  }

  private List<int[]> solve1(int[][] x) {
    int n = x.length, m = x[0].length;
    List<int[]> result = new ArrayList<>();
    int[] one = new int[2];
    int[][] zero = new int[3][2];
    int idx = 0;
    for (int i = n - 2; i < n; i++) {
      for (int j = m - 2; j < m; j++) {
        if (x[i][j] == 0) {
          zero[idx++] = new int[]{i, j};
        } else {
          one = new int[]{i, j};
        }
      }
    }
    result.add(new int[]{one[0], one[1], zero[0][0], zero[0][1], zero[1][0], zero[1][1]});
    x[one[0]][one[1]] ^= 1;
    x[zero[0][0]][zero[0][1]] ^= 1;
    x[zero[1][0]][zero[1][1]] ^= 1;
    result.addAll(solve2(x));
    return result;
  }

  private List<int[]> solve2(int[][] x) {
    int n = x.length, m = x[0].length;
    List<int[]> result = new ArrayList<>();
    int[] one = new int[2];
    int[][] zero = new int[3][2];
    int idx = 0;
    for (int i = n - 2; i < n; i++) {
      for (int j = m - 2; j < m; j++) {
        if (x[i][j] == 0) {
          zero[idx++] = new int[]{i, j};
        } else {
          one = new int[]{i, j};
        }
      }
    }
    result.add(new int[]{one[0], one[1], zero[0][0], zero[0][1], zero[1][0], zero[1][1]});
    x[one[0]][one[1]] ^= 1;
    x[zero[0][0]][zero[0][1]] ^= 1;
    x[zero[1][0]][zero[1][1]] ^= 1;
    result.addAll(solve3(x));
    return result;
  }

  private List<int[]> solve3(int[][] x) {
    int n = x.length, m = x[0].length;
    int[] entry = new int[6];
    int idx = 0;
    for (int row = n - 2; row < n; row++) {
      for (int col = m - 2; col < m; col++) {
        if (x[row][col] == 1) {
          entry[idx++] = row;
          entry[idx++] = col;
          x[row][col] ^= 1;
        }
      }
    }
    return Collections.singletonList(entry);
  }

  private List<int[]> solve4(int[][] x) {
    int n = x.length, m = x[0].length;
    List<int[]> result = new ArrayList<>();
    result.add(new int[]{n - 2, m - 2, n - 2, m - 1, n - 1, m - 1});
    x[n - 2][m - 2] = x[n - 2][m - 1] = x[n - 1][m - 1] = 0;
    result.addAll(solve1(x));
    return result;
  }

  private void print(List<int[]> x) {
    out.println(x.size());
    for (int[] entry : x) {
      for (int value : entry) {
        out.print(value + 1);
        out.print(' ');
      }
      out.println();
    }
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int ni() {
      return Integer.parseInt(next());
    }

    public long nl() {
      return Long.parseLong(next());
    }

    public void close() throws IOException {
      reader.close();
    }
  }

  public static void main(String[] args) throws IOException {
    try (BinaryTable instance = new BinaryTable()) {
      instance.solve();
    }
  }
}
