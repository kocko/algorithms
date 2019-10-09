package codeforces.contests801_900.problemset863;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Kayaking implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni() * 2;
    int[] w = new int[n];
    for (int i = 0; i < n; i++) {
      w[i] = in.ni();
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        List<Integer> pairs = new ArrayList<>();
        for (int k = 0; k < n; k++) {
          if (k != i && k != j) {
            pairs.add(w[k]);
          }
        }
        pairs.sort(Comparator.naturalOrder());
        int instability = 0;
        for (int k = 1; k < n - 2; k += 2) {
          instability += pairs.get(k) - pairs.get(k - 1);
        }
        if (instability < min) {
          min = instability;
        }
      }
    }
    out.println(min);
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
    try (Kayaking instance = new Kayaking()) {
      instance.solve();
    }
  }
}
