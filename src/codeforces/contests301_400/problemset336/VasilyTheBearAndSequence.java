package codeforces.contests301_400.problemset336;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class VasilyTheBearAndSequence implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] x = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
    }
    int beauty = -1;
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < 30; i++) {
      int bit = 1 << i, and = -1;
      List<Integer> list = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        if ((x[j] & bit) != 0) {
          if (and == -1) {
            and = x[j];
          } else {
            and &= x[j];
          }
          list.add(x[j]);
        }
      }
      int bestV = -1;
      for (int v = 0; v < 30; v++) {
        int divisor = 1 << v;
        if (and % divisor == 0) {
          bestV = v;
        }
      }
      if (bestV > beauty) {
        beauty = bestV;
        result = list;
      }
    }
    out.println(result.size());
    for (int value : result) {
      out.print(value);
      out.print(' ');
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
    try (VasilyTheBearAndSequence instance = new VasilyTheBearAndSequence()) {
      instance.solve();
    }
  }
}
