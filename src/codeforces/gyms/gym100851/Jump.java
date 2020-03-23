package codeforces.gyms.gym100851;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.StringTokenizer;

public class Jump implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    int[] s = new int[n], s1 = new int[n];
    while(true) {
      Random random = new Random();
      for (int i = 0; i < n; i++) {
        s[i] = random.nextInt(n) % 2;
      }
      int response = ask(s);
      if (response == n / 2) {
        s1[0] = s[0];
        break;
      }
    }
    for (int i = 1; i < n; i++) {
      s[0] ^= 1;
      s[i] ^= 1;
      int response = ask(s);
      s1[i] = response == n / 2 ? 1 : 0;
      s[0] ^= 1;
      s[i] ^= 1;
      if (s[i] == 1) {
        s1[i] ^= 1;
      }
    }
    ask(s1);
    for (int i = 0; i < n; i++) {
      s1[i] ^= 1;
    }
    ask(s1);
  }

  private int n;

  private int ask(int[] s) {
    for (int i = 0; i < n; i++) {
      out.print(s[i]);
    }
    out.println();
    out.flush();
    int response = in.ni();
    if (response == n) {
      System.exit(0);
    }
    return response;
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
    try (Jump instance = new Jump()) {
      instance.solve();
    }
  }
}
