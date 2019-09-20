package codeforces.contests1201_1300.problemset1221;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class _2048Game implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int q = in.ni();
    while (q-- > 0) {
      int n = in.ni();
      int[] cnt = new int[13];
      for (int i = 0; i < n; i++) {
        int next = in.ni();
        if (next <= 2048) {
          int idx = 0;
          while (next > 1) {
            idx++;
            next >>= 1;
          }
          cnt[idx]++;
          while (idx <= 10 && cnt[idx] == 2) {
            cnt[idx] = 0;
            cnt[idx + 1]++;
            idx++;
          }
        }
      }
      out.println(cnt[11] >= 1 ? "YES" : "NO");
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
    try (_2048Game instance = new _2048Game()) {
      instance.solve();
    }
  }
}
