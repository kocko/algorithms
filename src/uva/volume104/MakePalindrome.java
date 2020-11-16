package uva.volume104;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MakePalindrome implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    while (in.hasNextLine()) {
      solve(in.nextLine().toCharArray());
    }
  }

  private void solve(char[] x) {
    int n = x.length;
    if (n == 0) {
      out.println(0);
      return;
    }
    int[][] dp = new int[n][n];
    int[][] operation = new int[n][n];
    final int L = 0, R = 1, LR = 2;

    for (int length = 2; length <= n; length++) {
      for (int start = 0; start + length <= n; start++) {
        int end = start + length - 1;
        if (x[start] == x[end]) {
          dp[start][end] = dp[start + 1][end - 1];
          operation[start][end] = LR;
        } else {
          if (dp[start + 1][end] <= dp[start][end - 1]) {
            dp[start][end] = 1 + dp[start + 1][end];
            operation[start][end] = L;
          } else {
            dp[start][end] = 1 + dp[start][end - 1];
            operation[start][end] = R;
          }
        }
      }
    }
    int diff = dp[0][n - 1];
    char[] result = new char[x.length + diff];
    int left = 0, right = result.length - 1;
    int i = 0, j = n - 1;
    while (i <= j) {
      if (operation[i][j] == LR) {
        result[left] = result[right] = x[i];
        i++; j--;
      } else if (operation[i][j] == R) {
        result[left] = result[right] = x[j];
        j--;
      } else if (operation[i][j] == L) {
        result[left] = result[right] = x[i];
        i++;
      }
      left++;
      right--;
    }
    out.print(diff);
    out.print(' ');
    for (char c : result) {
      out.print(c);
    }
    out.println();
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
    try (MakePalindrome instance = new MakePalindrome()) {
      instance.solve();
    }
  }
}
