package codeforces.contests1401_1500.problemset1462;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LastYearsSubstring implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      char[] x = in.next().toCharArray();
      if (n < 4) {
        out.println("NO");
      } else {
        boolean possible = false;
        possible |= (x[0] == '2' && x[1] == '0' && x[2] == '2' && x[3] == '0');
        possible |= (x[0] == '2' && x[1] == '0' && x[2] == '2' && x[n - 1] == '0');
        possible |= (x[0] == '2' && x[1] == '0' && x[n - 2] == '2' && x[n - 1] == '0');
        possible |= (x[0] == '2' && x[n - 3] == '0' && x[n - 2] == '2' && x[n - 1] == '0');
        possible |= (x[n - 4] == '2' && x[n - 3] == '0' && x[n - 2] == '2' && x[n - 1] == '0');
        out.println(possible ? "YES" : "NO");
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
    try (LastYearsSubstring instance = new LastYearsSubstring()) {
      instance.solve();
    }
  }
}
