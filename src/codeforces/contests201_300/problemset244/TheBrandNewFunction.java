package codeforces.contests201_300.problemset244;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class TheBrandNewFunction implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    Set<Integer> set = new HashSet<>();
    boolean[] seen = new boolean[1 << 20];
    for (int i = 0; i < n; i++) {
      int value = in.ni();
      Set<Integer> next = new HashSet<>();
      next.add(value);
      seen[value] = true;
      for (int or : set) {
        seen[or | value] = true;
        next.add(or | value);
      }
      set = next;
    }
    int result = 0;
    for (int i = 0; i < seen.length; i++) {
      if (seen[i]) {
        result++;
      }
    }
    out.println(result);
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
    try (TheBrandNewFunction instance = new TheBrandNewFunction()) {
      instance.solve();
    }
  }
}
