package codeforces.contests1401_1500.problemset1475;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BallInBerland implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int a = in.ni(), b = in.ni(), k = in.ni();
      int[] x = new int[k];
      int[] y = new int[k];
      Map<Integer, Integer> boys = new HashMap<>();
      Map<Integer, Integer> girls = new HashMap<>();
      for (int i = 0; i < k; i++) {
        x[i] = in.ni();
        boys.put(x[i], boys.getOrDefault(x[i], 0) + 1);
      }
      for (int i = 0; i < k; i++) {
        y[i] = in.ni();
        girls.put(y[i], girls.getOrDefault(y[i], 0) + 1);
      }
      long result = 0;
      for (int i = 0; i < k; i++) {
        int unable = boys.get(x[i]) + girls.get(y[i]) - 2;
        result += k - unable - 1;
      }
      out.println(result / 2);
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
    try (BallInBerland instance = new BallInBerland()) {
      instance.solve();
    }
  }
}
