package codeforces.contests1101_1200.problemset1148;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Long.max;

public class BornThisWay implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    long ta = in.nl(), tb = in.nl();
    int k = in.ni();
    long[] a = new long[n], b = new long[m];
    for (int i = 0; i < n; i++) {
      a[i] = in.nl();
    }
    for (int i = 0; i < m; i++) {
      b[i] = in.nl();
    }
    if (n <= k || m <= k) {
      out.println(-1);
      return;
    }
    long arrival = -1;
    int idx = 0;
    for (int cancel = 0; cancel <= k; cancel++) {
      long timeInB = a[cancel] + ta;
      while (idx < m && b[idx] < timeInB) {
        idx++;
      }
      if (idx + k - cancel >= m) {
        arrival = -1;
        break;
      }
      arrival = max(arrival, b[idx + k - cancel] + tb);
    }
    out.println(arrival);
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
    try (BornThisWay instance = new BornThisWay()) {
      instance.solve();
    }
  }
}
