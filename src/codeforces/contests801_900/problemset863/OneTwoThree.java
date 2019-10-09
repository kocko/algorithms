package codeforces.contests801_900.problemset863;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OneTwoThree implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    long k = in.nl(), A = 0, B = 0;
    int a = in.ni() - 1, b = in.ni() - 1;
    for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) alice[i][j] = in.ni() - 1;
    for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) bob[i][j] = in.ni() - 1;

    dfs(a, b, 1);

    int currentA = a, currentB = b;
    while (k > 0 && (currentA != cycleStart[0] || currentB != cycleStart[1])) {
      if (score (currentA, currentB) > 0) {
        A++;
      } else if (score(currentA, currentB) < 0) {
        B++;
      }
      int next_b = bob[currentA][currentB];
      currentA = alice[currentA][currentB];
      currentB = next_b;
      k--;
    }

    if (k > 0) {
      long[] cycleScore = {0, 0};
      currentA = cycleStart[0];
      currentB = cycleStart[1];
      int next_a = alice[currentA][currentB], next_b = bob[currentA][currentB];
      while (true) {
        if (score(currentA, currentB) > 0) {
          cycleScore[0]++;
        } else if (score(currentB, currentA) > 0) {
          cycleScore[1]++;
        }
        if (next_a == cycleStart[0] && next_b == cycleStart[1]) {
          break;
        }
        currentA = next_a;
        currentB = next_b;
        next_a = alice[currentA][currentB];
        next_b = bob[currentA][currentB];
      }
      long fullCycles = k / cycle;
      A += fullCycles * cycleScore[0];
      B += fullCycles * cycleScore[1];
      k %= cycle;
      currentA = cycleStart[0];
      currentB = cycleStart[1];
      while (k > 0) {
        if (score(currentA, currentB) > 0) {
          A++;
        } else if (score(currentA, currentB) < 0) {
          B++;
        }
        next_a = alice[currentA][currentB];
        next_b = bob[currentA][currentB];
        currentA = next_a;
        currentB = next_b;
        k--;
      }
    }
    out.println(A + " " + B);
  }

  private int[][] alice = new int[3][3], bob = new int[3][3];
  private int[][] step = new int[3][3];
  private boolean[][] visited = new boolean[3][3];
  private int cycle = -1;
  private int[] cycleStart = {-1, -1};

  private void dfs(int a, int b, int current) {
    if (cycle != -1) return;
    step[a][b] = current;
    visited[a][b] = true;
    int next_a = alice[a][b], next_b = bob[a][b];
    if (!visited[next_a][next_b]) {
      dfs(next_a, next_b, current + 1);
    } else {
      cycleStart = new int[]{next_a, next_b};
      cycle = current + 1 - step[cycleStart[0]][cycleStart[1]];
    }
  }

  private int score(int a, int b) {
    if (a == 0) {
      if (b == 2) return 1;
      if (b == 1) return -1;
      if (b == 0) return 0;
    } else if (a == 1) {
      if (b == 2) return -1;
      if (b == 1) return 0;
      if (b == 0) return 1;
    } else {
      if (b == 2) return 0;
      if (b == 1) return 1;
      if (b == 0) return -1;
    }
    return 0;
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
    try (OneTwoThree instance = new OneTwoThree()) {
      instance.solve();
    }
  }
}
