package atcoder.beginner.contest164;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MultipleOf2019 implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[] x = in.next().toCharArray();
    int[] cnt = new int[2019];
    long result = 0;
    int rem = 0;
    cnt[rem]++;
    int[] ten = new int[x.length];
    ten[0] = 1;
    for (int i = 1; i < ten.length; i++) {
      ten[i] = ten[i - 1] * 10;
      ten[i] %= 2019;
    }
    for (int i = x.length - 1; i >= 0; i--) {
      int add = ten[x.length - i - 1] * (x[i] - '0');
      add %= 2019;
      rem = (rem + add) % 2019;
      result += cnt[rem];
      cnt[rem]++;
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
    try (MultipleOf2019 instance = new MultipleOf2019()) {
      instance.solve();
    }
  }
}
