package codeforces.contests1401_1500.problemset1430;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringDeletion implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      char[] x = in.next().toCharArray();
      List<Integer> groups = new ArrayList<>();
      char c = x[0];
      int current = 1;
      for (int i = 1; i < n; i++) {
        if (x[i] == c) {
          current++;
        } else {
          groups.add(current);
          current = 1;
          c = x[i];
        }
      }
      groups.add(current);
      int m = groups.size();
      int[] p = new int[m];
      for (int i = 0; i < m; i++) {
        p[i] = groups.get(i);
      }
      int result = 0;
      int left = 0, right = 0;
      while (right < m) {
        while (right < m && p[right] < 2) {
          right++;
        }
        if (right < m) {
          p[right]--;
        } else {
          break;
        }
        left++;
        result++;
        if (left > right) {
          right++;
        }
      }
      result += (m - left + 1) / 2;
      out.println(result);
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
    try (StringDeletion instance = new StringDeletion()) {
      instance.solve();
    }
  }
}
