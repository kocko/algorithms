package uva.volume115;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.min;

public class FewestFlops implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int tests = in.ni();
    while (tests-- > 0) {
      k = in.ni();
      x = in.next().toCharArray();
      dp = new Integer[x.length][27];
      out.println(recurse(k - 1, 0));
    }
  }

  private char[] x;
  private int k;

  private Integer[][] dp;

  private int recurse(int end, int flop) {
    if (end >= x.length) return 0;
    if (dp[end][flop] != null) return dp[end][flop];

    boolean[] has = new boolean[27];
    for (int i = end - k + 1; i <= end; i++) {
      has[x[i] - 'a' + 1] = true;
    }
    List<Integer> groups = new ArrayList<>();
    for (int i = 1; i <= 26; i++) {
      if (has[i]) {
        groups.add(i);
      }
    }
    int result = (int) 1e7;
    if (groups.size() == 1) {
      int left = groups.get(0);
      if (left != flop) {
        result = 1 + recurse(end + k, left);
      } else {
        result = recurse(end + k, left);
      }
    } else {
      for (int i = 0; i < groups.size(); i++) {
        for (int j = 0; j < groups.size(); j++) {
          if (i != j) {
            int left = groups.get(i), right = groups.get(j);
            if (left == flop) {
              result = min(result, groups.size() - 1 + recurse(end + k, right));
            } else {
              result = min(result, groups.size() + recurse(end + k, right));
            }
          }
        }
      }
    }
    return dp[end][flop] = result;
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
    try (FewestFlops instance = new FewestFlops()) {
      instance.solve();
    }
  }
}
