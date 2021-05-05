package codeforces.contests1501_1600.problemset1520;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class DoNotBeDistracted implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public DoNotBeDistracted() throws FileNotFoundException {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      char[] x = in.next().toCharArray();
      Set<Character> set = new HashSet<>();
      char key = x[0];
      int cnt = 0;
      for (int idx = 1; idx < n; idx++) {
        if (x[idx] != key) {
          set.add(key);
          key = x[idx];
          cnt++;
        }
      }
      set.add(key);
      cnt++;
      out.println(cnt == set.size() ? "YES" : "NO");
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
    try (DoNotBeDistracted instance = new DoNotBeDistracted()) {
      instance.solve();
    }
  }
}
