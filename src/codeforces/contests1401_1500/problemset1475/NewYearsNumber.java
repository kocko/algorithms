package codeforces.contests1401_1500.problemset1475;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NewYearsNumber implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    final int MAX_N = (int) 1e6;
    boolean[] can = new boolean[MAX_N + 1];
    for (int i = 2020; i <= MAX_N; i++) {
      for (int times = 0; times * 2020 <= i && times <= 1000; times++) {
        int rem = i - times * 2020;
        if (rem % 2021 == 0) {
          can[i] = true;
        }
      }
    }
    while (t-- > 0) {
      int n = in.ni();
      out.println(can[n] ? "YES" : "NO");
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
    try (NewYearsNumber instance = new NewYearsNumber()) {
      instance.solve();
    }
  }
}
