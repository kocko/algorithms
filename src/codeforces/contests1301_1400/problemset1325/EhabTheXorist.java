package codeforces.contests1301_1400.problemset1325;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EhabTheXorist implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    long xor = in.nl(), sum = in.nl();
    if (xor % 2 != sum % 2 || xor > sum) {
      out.println(-1);
    } else if (xor == sum) {
      if (sum == 0) {
        out.println(0);
      } else {
        out.println(1);
        out.println(sum);
      }
    } else {
      long x = (sum - xor) / 2;
      if ((xor & x) != 0) {
        out.println(3);
        out.println(xor + " " + x + " " + x);
      } else {
        out.println(2);
        out.println((xor ^ x) + " " + x);
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
    try (EhabTheXorist instance = new EhabTheXorist()) {
      instance.solve();
    }
  }
}
