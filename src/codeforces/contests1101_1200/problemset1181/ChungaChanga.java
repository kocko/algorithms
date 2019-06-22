package codeforces.contests1101_1200.problemset1181;

import java.io.*;
import java.util.StringTokenizer;

public class ChungaChanga implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    long x = in.nl(), y = in.nl(), z = in.nl();
    long a = x / z, b = y / z;
    long coconuts = a + b, debt = 0;
    {
      long change = y % z;
      long nuts = (x + change) / z;
      long rem = (x + change) % z;
      if (nuts + b > coconuts) {
        coconuts = nuts + b;
        debt = change - rem;
      } else if (nuts + b == coconuts && change - rem >= 0) {
        debt = Math.min(debt, change - rem);
      }
    }
    {
      long change = x % z;
      long nuts = (y + change) / z;
      long rem = (y + change) % z;
      if (nuts + a > coconuts) {
        coconuts = nuts + a;
        debt = change - rem;
      } else if (nuts + a == coconuts && change - rem >= 0) {
        debt = Math.min(debt, change - rem);
      }
    }
    out.println(coconuts + " " + debt);
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
    try (ChungaChanga instance = new ChungaChanga()) {
      instance.solve();
    }
  }
}
