package google.codejam2019.qualification;

import java.io.*;
import java.util.StringTokenizer;

public class YouCanGoYourOwnWay implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    for (int testCase = 1; testCase <= t; testCase++) {
      int n = in.ni();
      char[] x = in.next().toCharArray();
      out.printf("Case #%d: ", testCase);
      for (int i = 0; i < 2 * n - 2; i++) {
        out.print(x[i] == 'S' ? 'E' : 'S');
      }
      out.println();
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
    try (YouCanGoYourOwnWay instance = new YouCanGoYourOwnWay()) {
      instance.solve();
    }
  }
}
