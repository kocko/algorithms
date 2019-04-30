package codeforces.gyms.gym100971;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Repair implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    a = in.ni();
    b = in.ni();
    if (a < b) a = b ^ a ^ (b = a);

    int a1 = in.ni(), b1 = in.ni();
    if (a1 < b1) a1 = b1 ^ a1 ^ (b1 = a1);

    int a2 = in.ni(), b2 = in.ni();
    if (a2 < b2) a2 = b2 ^ a2 ^ (b2 = a2);

    boolean possible = fits(a1, b1, a2, b2);
    out.println(possible ? "YES" : "NO");
  }

  private int a, b;

  private boolean fits(int a1, int b1, int a2, int b2) {
    boolean result;
    result = a1 + a2 <= a && max(b1, b2) <= b;
    result |= a1 + b2 <= a && max(b1, a2) <= b;
    result |= max(a1, b2) <= a && b1 + a2 <= b;
    result |= max(a1, a2) <= a && b1 + b2 <= b;
    
    result |= a1 + a2 <= b && max(b1, b2) <= a;
    result |= a1 + b2 <= b && max(b1, a2) <= a;
    result |= max(a1, b2) <= b && b1 + a2 <= a;
    result |= max(a1, a2) <= b && b1 + b2 <= a;
    
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
    try (Repair instance = new Repair()) {
      instance.solve();
    }
  }
}
