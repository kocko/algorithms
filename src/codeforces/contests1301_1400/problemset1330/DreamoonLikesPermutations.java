package codeforces.contests1301_1400.problemset1330;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DreamoonLikesPermutations implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[] x = new int[n];
      boolean[] has = new boolean[n + 1];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
        has[x[i]] = true;
      }
      int maxSize = 0;
      for (int i = 1; i <= n; i++) {
        if (!has[i]) {
          maxSize = i - 1;
          break;
        }
      }
      int[] maxLeft = new int[n], minLeft = new int[n];
      maxLeft[0] = minLeft[0] = x[0];
      for (int i = 1; i < n; i++) {
        maxLeft[i] = Math.max(maxLeft[i - 1], x[i]);
        minLeft[i] = Math.min(minLeft[i - 1], x[i]);
      }
      int[] maxRight = new int[n], minRight = new int[n];
      maxRight[n - 1] = minRight[n - 1] = x[n - 1];
      for (int i = n - 2; i >= 0; i--) {
        maxRight[i] = Math.max(maxRight[i + 1], x[i]);
        minRight[i] = Math.min(minRight[i + 1], x[i]);
      }
      List<int[]> result = new ArrayList<>();
      for (int i = 0; i < n - 1; i++) {
        int sizeLeft = i + 1, sizeRight = n - sizeLeft;
        if (maxLeft[i] == sizeLeft && maxRight[i + 1] == sizeRight && sizeLeft <= maxSize && sizeRight <= maxSize) {
          boolean[] lft = new boolean[sizeLeft + 1];
          boolean[] rgh = new boolean[sizeRight + 1];
          for (int j = 0; j <= i; j++) {
            lft[x[j]] = true;
          }
          for (int j = i + 1; j < n; j++) {
            rgh[x[j]] = true;
          }
          boolean ok = true;
          for (int j = 1; j <= sizeLeft; j++) {
            ok &= lft[j];
          }
          for (int j = 1; j <= sizeRight; j++) {
            ok &= rgh[j];
          }
          if (ok) {
            result.add(new int[]{sizeLeft, sizeRight});
          }
        }
      }
      out.println(result.size());
      for (int[] pair : result) {
        out.println(pair[0] + " " + pair[1]);
      }
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
    try (DreamoonLikesPermutations instance = new DreamoonLikesPermutations()) {
      instance.solve();
    }
  }
}
