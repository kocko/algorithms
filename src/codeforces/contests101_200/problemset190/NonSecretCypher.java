package codeforces.contests101_200.problemset190;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class NonSecretCypher implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), k = in.ni();
    int[] x = new int[n];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
      map.put(x[i], 0);
    }
    long result = 0;
    int left = 0, right = -1;
    boolean expand = true;
    while (left < n) {
      while (right + 1 < n && expand) {
        right++;
        int count = map.get(x[right]);
        map.put(x[right], count + 1);
        if (count + 1 == k) {
          expand = false;
        }
      }
      if (!expand) {
        result += (long) (n - right);
      }
      int first = map.get(x[left]);
      map.put(x[left], first - 1);
      left++;
      if (first == k) {
        expand = true;
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
    try (NonSecretCypher instance = new NonSecretCypher()) {
      instance.solve();
    }
  }
}
