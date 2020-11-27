package uva.volume012;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.String.valueOf;

public class PalindromicPaths implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      graph = new char[n][n];
      for (int i = 0; i < n; i++) {
        graph[i] = in.next().toCharArray();
      }
      dp = new String[n][n];
      out.println(recurse(0, n - 1));
    }
  }

  private char[][] graph;
  private String[][] dp;

  private String recurse(int left, int right) {
    if (left == right) return "";
    if (dp[left][right] != null) return dp[left][right];

    String ans = valueOf(graph[left][right]);
    for (int i = left + 1; i <= right; i++) {
      char letter = graph[left][i];
      for (int j = i; j <= right; j++) {
        if (graph[j][right] == letter) {
          String temp = letter + recurse(i, j) + letter;
          if (temp.length() > ans.length()) {
            ans = temp;
          } else if (temp.length() == ans.length() && temp.compareTo(ans) < 0) {
            ans = temp;
          }
        }
      }
    }
    return dp[left][right] = ans;
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
    try (PalindromicPaths instance = new PalindromicPaths()) {
      instance.solve();
    }
  }
}
