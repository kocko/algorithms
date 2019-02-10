package codeforces.contests1101_1200.problemset1114;

import java.io.*;
import java.util.StringTokenizer;

public class GotAnyGrapes implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int x = in.ni(), y = in.ni(), z = in.ni();
    int a = in.ni(), b = in.ni(), c = in.ni();
    int ab = a + b, abc = a + b + c;
    boolean ok = x <= a;
    ab -= x;
    abc -= x;
    ok &= y <= ab;
    abc -= y;
    ok &= z <= abc;
    out.println(ok ? "YES" : "NO");
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
    try (GotAnyGrapes instance = new GotAnyGrapes()) {
      instance.solve();
    }
  }
}
