package timus.volume07;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MnemonicsAndPalindromes implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    String x = in.next();
    analyze(x);
    dp = new Integer[n];
    next = new int[n];
    int cuts = recurse(0);
    out.println(cuts);
    int start = 0, end = next[0];
    while (start < n) {
      out.print(x.substring(start, end));
      out.print(' ');
      start = end;
      if (start < n) {
        end = next[start];
      }
    }
    out.println();
  }

  private int n;
  private boolean[][] palindrome;

  private void analyze(String x) {
    char[] s = x.toCharArray();
    n = s.length;
    palindrome = new boolean[n][n];
    for (int size = 1; size <= n; size++) {
      for (int i = 0; i < n; i++) {
        if (size == 1) {
          palindrome[i][i] = true;
        }
        if (size == 2 && i + 1 < n) {
          palindrome[i][i + 1] = s[i] == s[i + 1];
        }
        if (size > 2 && i + size <= n) {
          palindrome[i][i + size - 1] = s[i] == s[i + size - 1] && palindrome[i + 1][i + size - 2];
        }
      }
    }
  }

  private Integer[] dp;
  private int[] next;

  private int recurse(int start) {
    if (start == n) return 0;

    if (dp[start] != null) return dp[start];

    int ans = n;
    next[start] = start + 1;

    for (int size = 1; size <= n - start; size++) {
      if (palindrome[start][start + size - 1]) {
        int score = 1 + recurse(start + size);
        if (score < ans) {
          ans = score;
          next[start] = start + size;
        }
      }
    }
    return dp[start] = ans;
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
    try (MnemonicsAndPalindromes instance = new MnemonicsAndPalindromes()) {
      instance.solve();
    }
  }
}
