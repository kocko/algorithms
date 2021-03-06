package codeforces.contests1101_1200.problemset1195;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DrinksChoosing implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), k = in.ni();
    int[] count = new int[k + 1];
    for (int i = 0; i < n; i++) {
      int next = in.ni();
      count[next]++;
    }
    Arrays.sort(count);
    int sets = n / 2 + (n % 2), result = 0;
    for (int i = count.length - 1; i > 0; i--) {
      if (sets > 0) {
        result += count[i] - (count[i] % 2);
        sets -= count[i] / 2;
        count[i] %= 2;
      }
    }
    for (int i = count.length - 1; i > 0; i--) {
      if (sets > 0) {
        result++;
        sets--;
        count[i] = 0;
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
    try (DrinksChoosing instance = new DrinksChoosing()) {
      instance.solve();
    }
  }
}
