package codeforces.contests101_200.problemset143;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HelpFarmer implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int sqrt = (int) Math.sqrt(n);
    long max = 0, min = Long.MAX_VALUE;
    for (int a = 1; a <= sqrt; a++) {
      if (n % a == 0) {
        for (int side : new int[]{a, n / a}) {
          int bc = n / side;
          int sq = (int) Math.sqrt(bc);
          for (int b = 1; b <= sq; b++) {
            if (bc % b == 0) {
              int c = bc / b;
              long volume = (side + 1L) * (b + 2L) * (c + 2L);
              max = Math.max(max, volume - n);
              min = Math.min(min, volume - n);
            }
          }
        }
      }
    }
    out.println(min + " " + max);
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
    try (HelpFarmer instance = new HelpFarmer()) {
      instance.solve();
    }
  }
}
