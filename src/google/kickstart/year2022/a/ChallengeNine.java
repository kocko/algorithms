package google.kickstart.year2022.a;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ChallengeNine implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public ChallengeNine() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    for (int testCase = 1; testCase <= T; testCase++) {
      char[] x = in.next().toCharArray();
      int sum = 0;
      for (char c : x) {
        sum += (c - '0');
      }
      int digit = (9 - (sum % 9)) % 9;
      boolean inserted = false;
      StringBuilder result = new StringBuilder();
      for (int idx = 0; idx < x.length; idx++) {
        char c = x[idx];
        if (!inserted && (digit != 0 || idx > 0) && digit < (c - '0')) {
          result.append(digit);
          inserted = true;
        }
        result.append(c);
      }
      if (!inserted) {
        result.append(digit);
      }
      out.printf("Case #%d: %s\n", testCase, result);
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
    try (ChallengeNine instance = new ChallengeNine()) {
      instance.solve();
    }
  }
}
