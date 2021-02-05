package codeforces.contests1401_1500.problemset1481;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class NewColony implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), k = in.ni();
      int[] h = new int[n];
      for (int i = 0; i < n; i++) {
        h[i] = in.ni();
      }
      int pos = -1;
      while (k > 0) {
        int idx = 0;
        boolean falls;
        while (true) {
          if (idx == n - 1) {
            falls = true;
            break;
          }
          if (h[idx] >= h[idx + 1]) {
            idx++;
          } else {
            h[idx]++;
            pos = idx + 1;
            k--;
            falls = false;
            break;
          }
        }
        if (falls) {
          break;
        }
      }
      out.println(k > 0 ? -1 : pos);
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
    try (NewColony instance = new NewColony()) {
      instance.solve();
    }
  }
}
