package codeforces.contests501_600.problemset577;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ModuloSum implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    m = in.ni();
    rem = new int[m];
    for (int i = 0; i < n; i++) {
      rem[in.ni() % m]++;
    }
    if (n > m) {
      out.println("YES"); 
    } else {
      dp = new Boolean[m][m][2];
      boolean ans = rem[0] >= 1 || recurse(1, 0, 0);
      out.println(ans ? "YES" : "NO");
    }
  }
  
  private int m;
  private int[] rem;
  private Boolean[][][] dp;
  
  private boolean recurse(int idx, int sum, int empty) {
    if (idx == rem.length) return sum == 0 && empty == 1;
    
    if (dp[idx][sum][empty] != null) return dp[idx][sum][empty];
    boolean ans = false;
    for (int count = 0; count <= rem[idx]; count++) {
      if (count == 0) {
        ans |= recurse(idx + 1, (sum + count * idx) % m, empty);
      } else {
        ans |= recurse(idx + 1, (sum + count * idx) % m, 1);
      }
    }
    return dp[idx][sum][empty] = ans;
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
    try (ModuloSum instance = new ModuloSum()) {
      instance.solve();
    }
  }
}
