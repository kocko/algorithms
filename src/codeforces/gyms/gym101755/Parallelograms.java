package codeforces.gyms.gym101755;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Parallelograms implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), MAX = 200000;
    int[] cnt = new int[MAX + 1];
    int result = 0;
    for (int i = 0; i < n; i++) {
      int next = in.ni();
      if (++cnt[next] == 4) {
        result++;
        cnt[next] = 0;
      }
    }
    Arrays.sort(cnt);
    for (int i = 1; i < MAX; i++) {
      int a = cnt[i] / 2, b = cnt[i + 1] / 2, pairs = Math.min(a, b);
      result += pairs;
      cnt[i + 1] -= 2 * pairs;
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
    try (Parallelograms instance = new Parallelograms()) {
      instance.solve();
    }
  }
}
