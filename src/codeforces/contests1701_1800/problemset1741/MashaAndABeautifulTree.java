package codeforces.contests1701_1800.problemset1741;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class MashaAndABeautifulTree implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      x = new int[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
      }
      swaps = 0;
      possible = true;
      recurse(0, n - 1);
      out.println(possible ? swaps : -1);
    }
  }

  private int swaps;
  private boolean possible;
  private int[] x;

  private int[] recurse(int left, int right) {
    if (left == right) return new int[]{1, x[left], x[right]};
    int mid = (left + right) / 2;
    int[] a = recurse(left, mid);
    int[] b = recurse(mid + 1, right);
    int[] result = new int[3];
    result[0] = (a[0] == -1 || b[0] == -1) ? -1 : 1;
    possible &= result[0] == 1;
    if (a[1] > b[2]) {
      swaps++;
      result[1] = b[1];
      result[2] = a[2];
    } else if (b[1] > a[2]) {
      result[1] = a[1];
      result[2] = b[2];
    } else {
      possible = false;
      result[0] = -1;
    }
    return result;
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
    try (MashaAndABeautifulTree instance = new MashaAndABeautifulTree()) {
      instance.solve();
    }
  }
}