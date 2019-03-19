package codechef;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class ChangeTheSigns implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      n = in.ni();
      x = new long[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.nl();
      }
      dp = new Long[n][2];
      out.println(recurse(0, 0));
    }
  }
  
  private int n;
  private long[] x;
  
  private Long[][] dp;
  
  private long recurse(int idx, int negated) {
    if (idx >= n) return 0;
    
    if (dp[idx][negated] != null) return dp[idx][negated];
    
    long pos = x[idx] + recurse(idx + 1, 0);
    
    long neg = Integer.MAX_VALUE;
    if (negated == 1) {
      if (x[idx] < x[idx - 1] - x[idx - 2] && (idx == n - 1 || x[idx] < x[idx + 1])) {
        neg = min(recurse(idx + 2, 1) - x[idx] + (idx < n - 1 ? x[idx + 1] : 0), neg);
      }
    } else {
      if (idx == 0 && idx + 1 < n && x[idx] < x[idx + 1]) {
        neg = min(neg, recurse(idx + 2, 1) - x[idx] + x[idx + 1]);
      } 
      if (idx > 0 && x[idx] < x[idx - 1] && (idx == n - 1 || x[idx] < x[idx + 1])) {
        neg = min(recurse(idx + 2, 1) - x[idx] + (idx < n - 1 ? x[idx + 1] : 0), neg);
      }
    }
    
    return dp[idx][negated] = min(pos, neg);
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
    try (ChangeTheSigns instance = new ChangeTheSigns()) {
      instance.solve();
    }
  }
}
