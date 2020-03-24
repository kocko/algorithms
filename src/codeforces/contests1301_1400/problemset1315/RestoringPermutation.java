package codeforces.contests1301_1400.problemset1315;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RestoringPermutation implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[] result = new int[2 * n];
      boolean[] taken = new boolean[2 * n + 1];
      for (int i = 0; i < 2 * n; i += 2) {
        int next = in.ni();
        result[i] = next;
        taken[next] = true;
      }
      boolean possible = true;
      for (int i = 1; i < 2 * n; i += 2) {
        int min = firstFreeBiggerThan(taken, result[i - 1]);
        if (min == -1) {
          possible = false;
          break;
        }
        taken[min] = true;
        result[i] = min;
      }
      if (possible) {
        for (int i = 0; i < 2 * n; i++) {
          out.print(result[i]);
          out.print(' ');
        }
        out.println();
      } else {
        out.println(-1);
      }
    }
  }

  private int firstFreeBiggerThan(boolean[] taken, int limit) {
    for (int i = limit + 1; i < taken.length; i++) {
      if (!taken[i]) {
        return i;
      }
    }
    return -1;
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
    try (RestoringPermutation instance = new RestoringPermutation()) {
      instance.solve();
    }
  }
}
