package codeforces.contests301_400.problemset353;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FindMaximum implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] x = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
    }
    char[] bits = in.next().toCharArray();
    int[] mPrefix = new int[n], prefix = new int[n];
    for (int i = 0; i < n; i++) {
      prefix[i] = x[i];
      mPrefix[i] = bits[i] == '1' ? x[i] : 0;
      if (i > 0) {
        prefix[i] += prefix[i - 1];
        mPrefix[i] += mPrefix[i - 1];
      }
    }
    int result = mPrefix[n - 1];
    for (int i = 0; i < n; i++) {
      if (bits[i] == '1') {
        int right = i > 0 ? prefix[i - 1] : 0;
        int left = mPrefix[n - 1] - mPrefix[i];
        if (left + right > result) {
          result = left + right;
        }
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
    try (FindMaximum instance = new FindMaximum()) {
      instance.solve();
    }
  }
}
