package usaco.year2017.february;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class WhyDidTheCowCrossTheRoadII implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public WhyDidTheCowCrossTheRoadII() throws FileNotFoundException {
    in = new InputReader(new FileInputStream("maxcross.in"));
    out = new PrintWriter(new FileOutputStream("maxcross.out"));
  }

  public void solve() {
    int n = in.ni(), k = in.ni(), b = in.ni();
    int[] broken = new int[n + 1];
    for (int i = 0; i < b; i++) {
      int idx = in.ni();
      broken[idx] = 1;
    }
    for (int i = 1; i <= n; i++) {
      broken[i] += broken[i - 1];
    }
    int result = Integer.MAX_VALUE;
    for (int i = k; i <= n; i++) {
      result = Math.min(result, broken[i] - broken[i - k]);
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
    try (WhyDidTheCowCrossTheRoadII instance = new WhyDidTheCowCrossTheRoadII()) {
      instance.solve();
    }
  }
}
