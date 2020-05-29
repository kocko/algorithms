package codeforces.gyms.gym100090;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BracketSequence implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[] x = in.next().toCharArray();
    int n = x.length;
    int balance = 0;
    boolean possible = true;
    for (int i = 0; i < n; i++) {
      if (x[i] == '(') balance++;
      else balance--;
      if (balance < 0) {
        possible = false;
        break;
      }
    }
    if (!possible) {
      out.println("IMPOSSIBLE");
    } else {
      for (int i = 0; i < n; i++) {
        out.print(x[i]);
      }
      while (balance > 0) {
        out.print(')');
        balance--;
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
    try (BracketSequence instance = new BracketSequence()) {
      instance.solve();
    }
  }
}
