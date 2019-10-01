package codeforces.contests1201_1300.problemset1228;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DistinctDigits implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int left = in.ni(), right = in.ni();
    for (int i = left; i <= right; i++) {
      if (distinct(i)) {
        out.println(i);
        return;
      }
    }
    out.println(-1);
  }

  private boolean distinct(int x) {
    int[] cnt = new int[10];
    while (x > 0) {
      cnt[x % 10]++;
      x /= 10;
    }
    boolean different = true;
    for (int i = 0; i < 10; i++) {
      different &= cnt[i] <= 1;
    }
    return different;
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
    try (DistinctDigits instance = new DistinctDigits()) {
      instance.solve();
    }
  }
}
