package codeforces.contests1401_1500.problemset1401;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Comparator.naturalOrder;

public class MereArray implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), min = Integer.MAX_VALUE;
      List<Integer> list = new ArrayList<>(), copy = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        int next = in.ni();
        list.add(next);
        copy.add(next);
        min = Math.min(min, next);
      }
      boolean possible = true;
      copy.sort(naturalOrder());
      for (int i = 0; i < n; i++) {
        int a = list.get(i), b = copy.get(i);
        if (a != b && a % min != 0) {
          possible = false;
          break;
        }
      }
      out.println(possible ? "YES" : "NO");
    }
  }

  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
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
    try (MereArray instance = new MereArray()) {
      instance.solve();
    }
  }
}
