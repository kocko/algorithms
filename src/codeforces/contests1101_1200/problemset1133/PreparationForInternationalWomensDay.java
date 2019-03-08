package codeforces.contests1101_1200.problemset1133;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PreparationForInternationalWomensDay implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), k = in.ni();
    long[] cnt = new long[k];
    for (int i = 0; i < n; i++) {
      int next = in.ni();
      cnt[next % k]++;
    }
    long result = cnt[0] / 2;
    for (int i = 1; i < k; i++) {
      if (i != k - i) {
        long min = Math.min(cnt[i], cnt[k - i]);
        result += min;
        cnt[i] -= min;
        cnt[k - i] -= min;
      } else {
        result += cnt[i] / 2;
      }
    }
    out.println(result * 2);
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
    try (PreparationForInternationalWomensDay instance = new PreparationForInternationalWomensDay()) {
      instance.solve();
    }
  }
}
