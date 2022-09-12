package facebook.hackercup2022.round1;

import java.io.*;
import java.util.StringTokenizer;

public class WateringWell implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public WateringWell(String input, String output) throws IOException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int T = in.ni();
    for (int testCase = 1; testCase <= T; testCase++) {
      solve(testCase);
    }
  }

  private final long MOD = (long) 1e9 + 7;

  private void solve(int testCase) {
    int n = in.ni();
    long result = 0;
    long sumA = 0, sumB = 0;
    long sqA = 0, sqB = 0;
    for (int i = 0; i < n; i++) {
      long a = in.nl(), b = in.nl();
      sumA = (sumA + a) % MOD;
      sumB = (sumB + b) % MOD;
      sqA = (a * a % MOD + sqA) % MOD;
      sqB = (b * b % MOD + sqB) % MOD;
    }

    int q = in.ni();
    while (q-- > 0) {
      long x = in.nl(), y = in.nl();
      result = (result + n * x % MOD * x % MOD) % MOD;
      long sub = sumA * x % MOD;
      result = (result - sub + MOD) % MOD;
      result = (result - sub + MOD) % MOD;
      result = (result + sqA) % MOD;

      result = (result + n * y % MOD * y % MOD) % MOD;
      sub = sumB * y % MOD;
      result = (result - sub + MOD) % MOD;
      result = (result - sub + MOD) % MOD;
      result = (result + sqB) % MOD;
    }
    out.printf("Case #%d: %d\n", testCase, result);
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
    try (WateringWell instance = new WateringWell("input.txt", "output.txt")) {
      instance.solve();
    }
  }
}