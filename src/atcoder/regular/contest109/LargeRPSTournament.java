package atcoder.regular.contest109;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LargeRPSTournament implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), k = in.ni();
    String s = in.next();

    while (k-- > 0) {
      String t = s + s;
      StringBuilder next = new StringBuilder();
      for (int i = 0; i < n; i++) {
        next.append(play(t.charAt(2 * i), t.charAt(2 * i + 1)));
      }
      s = next.toString();
    }
    out.println(s.charAt(0));
  }

  private char play(char a, char b) {
    if (a == 'R') return b == 'P' ? b : a;
    if (a == 'P') return b == 'S' ? b : a;
    if (a == 'S') return b == 'R' ? b : a;
    return 0x0000;
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
    try (LargeRPSTournament instance = new LargeRPSTournament()) {
      instance.solve();
    }
  }
}
