package codeforces.gyms.gym101755;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class VideoReviews implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    m = in.ni();
    a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.ni();
    }
    int left = 0, right = m, result = m;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (ok(mid)) {
        result = Math.min(result, mid);
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    out.println(result);
  }

  private int n, m;
  private int[] a;

  private boolean ok(int x) {
    int videos = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] <= videos) {
        videos++;
      } else if (x > 0) {
        x--;
        videos++;
      }
      if (videos == m) return true;
    }
    return false;
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
    try (VideoReviews instance = new VideoReviews()) {
      instance.solve();
    }
  }
}
