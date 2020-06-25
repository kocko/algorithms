package codeforces.contests1301_1400.problemset1365;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RotationMatching implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] a = new int[n];
    int[] pos = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.ni() - 1;
      pos[a[i]] = i;
    }
    for (int i = 0; i < n; i++) {
      b[i] = in.ni() - 1;
    }
    int[] cnt = new int[n];
    for (int i = 0; i < n; i++) {
      int target = pos[b[i]];
      if (i <= target) {
        cnt[target - i]++;
      } else {
        cnt[n - i + target]++;
      }
    }
    int max = 0;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, cnt[i]);
    }
    out.println(max);
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
    try (RotationMatching instance = new RotationMatching()) {
      instance.solve();
    }
  }
}
