package codeforces.contests1301_1400.problemset1321;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ContestForRobots implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.ni();
    }
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      b[i] = in.ni();
    }
    int maxB = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] == 0 && b[i] == 1) {
        maxB++;
      }
    }
    int target = maxB;
    int good = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] == 1 && b[i] == 0) {
        good++;
      }
    }
    out.println(good == 0 ? -1 : target / good + 1);
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
    try (ContestForRobots instance = new ContestForRobots()) {
      instance.solve();
    }
  }
}
