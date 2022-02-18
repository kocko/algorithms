package google.kickstart.year2022.warmup;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.Predicate;

public class CentauriPrime implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public CentauriPrime() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    Predicate<Character> isVowel = (Character c) -> "AEIOUaeiou".indexOf(c) >= 0;
    for (int testCase = 1; testCase <= T; testCase++) {
      char[] next = in.next().toCharArray();
      int n = next.length;
      String ruler = "nobody";
      if (next[n - 1] != 'y' && next[n - 1] != 'Y') {
        if (isVowel.test(next[next.length - 1])) {
          ruler = "Alice";
        } else {
          ruler = "Bob";
        }
      }
      out.printf("Case #%d: %s is ruled by %s.\n", testCase, new String(next), ruler);
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
    try (CentauriPrime instance = new CentauriPrime()) {
      instance.solve();
    }
  }
}
