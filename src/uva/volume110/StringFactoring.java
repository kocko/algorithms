package uva.volume110;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StringFactoring implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    String s;
    while (!"*".equals(s = in.next())) {
      String bestEncoding = dp(s);
      out.println(score(bestEncoding));
    }
  }


  private int repeatedSubstringPattern(String s) {
    char[] x = s.toCharArray();
    int n = x.length;
    int[] prefix = new int[n];

    for (int i = 1; i < n; i++) {
      int j = prefix[i - 1];
      while (j > 0 && x[i] != x[j]) {
        j = prefix[j - 1];
      }
      if (x[i] == x[j]) {
        j++;
      }
      prefix[i] = j;
    }
    int l = prefix[n - 1];
    return l != 0 && n % (n - l) == 0 ? (n - l) : n;
  }

  private String dp(String s) {
    char[] x = s.toCharArray();
    int n = x.length;
    char[] tmp = new char[81];
    Arrays.fill(tmp, 'X');
    final String oo = new String(tmp);

    String[][] dp = new String[n][n];
    for (int len = 1; len <= n; len++) {
      for (int start = 0; start <= n - len; start++) {
        int end = start + len - 1;
        if (len == 1) {
          dp[start][end] = s.substring(start, end + 1);
        } else {
          String minConcatenation = oo;
          int repeatedLength = repeatedSubstringPattern(s.substring(start, end + 1));
          int times = len / repeatedLength;
          StringBuilder temp;
          if (times > 1) {
            temp = new StringBuilder(times + "[");
            temp.append(dp[start][start + repeatedLength - 1]);
            temp.append(']');
          } else {
            temp = new StringBuilder(s.substring(start, end + 1));
          }
          if (score(temp.toString()) < score(minConcatenation)) {
            minConcatenation = temp.toString();
          }
          for (int mid = start; mid < end; mid++) {
            String a = dp[start][mid] + dp[mid + 1][end];
            if (score(a) < score(minConcatenation)) {
              minConcatenation = a;
            }
          }
          dp[start][end] = minConcatenation;
        }
      }
    }
    return dp[0][n - 1];
  }

  private int score(String s) {
    int result = 0;
    for (char c : s.toCharArray()) {
      if (c >= 'A' && c <= 'Z') {
        result++;
      }
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
    try (StringFactoring instance = new StringFactoring()) {
      instance.solve();
    }
  }
}
