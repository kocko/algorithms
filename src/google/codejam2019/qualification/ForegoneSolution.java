package google.codejam2019.qualification;

import java.io.*;
import java.util.StringTokenizer;

public class ForegoneSolution implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    for (int testCase = 1; testCase <= t; testCase++) {
      char[] x = in.next().toCharArray();
      int n = x.length;
      StringBuilder a = new StringBuilder(), b = new StringBuilder();
      for (int i = n - 1; i >= 0; i--) {
        if (x[i] == '4') {
          a.append('2');
          b.append('2');
        } else {
          a.append(x[i]);
          b.append('0');
        }
      }
      String p = trim(a.reverse().toString());
      String q = trim(b.reverse().toString());
      out.printf("Case #%d: %s %s\n", testCase, p, q);
    }
  }
  
  private String trim(String x) {
    int start;
    for (start = 0; start < x.length(); start++) {
      if (x.charAt(start) != '0') break;
    }
    StringBuilder result = new StringBuilder();
    while (start < x.length()) {
      result.append(x.charAt(start++));
    }
    return result.toString();
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
    try (ForegoneSolution instance = new ForegoneSolution()) {
      instance.solve();
    }
  }
}
