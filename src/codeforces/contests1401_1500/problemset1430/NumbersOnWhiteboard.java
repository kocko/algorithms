package codeforces.contests1401_1500.problemset1430;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NumbersOnWhiteboard implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      List<int[]> operations = new ArrayList<>();
      if (n == 2) {
        operations.add(new int[]{1, 2});
      } else {
        int i = n - 2;
        operations.add(new int[]{i, i + 2});
        operations.add(new int[]{i + 1, i + 1});
        while (--i > 0) {
          operations.add(new int[]{i, i + 2});
        }
      }
      out.println(2);
      for (int[] op : operations) {
        out.println(op[0] + " " + op[1]);
      }
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
    try (NumbersOnWhiteboard instance = new NumbersOnWhiteboard()) {
      instance.solve();
    }
  }
}
