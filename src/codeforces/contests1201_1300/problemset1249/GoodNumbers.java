package codeforces.contests1201_1300.problemset1249;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GoodNumbers implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      long n = in.nl();
      char[] ternary = ternary(n).toCharArray();
      int pos;
      while ((pos = rightMostTwo(ternary)) != -1) {
        StringBuilder next = new StringBuilder();
        for (int i = 0; i <= pos; i++) {
          next.append(0);
        }
        int carry = 1;
        for (int i = pos + 1; i < ternary.length; i++) {
          int value = (ternary[i] - '0') + carry;
          if (value == 3) {
            next.append(0);
            carry = 1;
          } else {
            next.append(value);
            carry = 0;
          }
        }
        if (carry > 0) {
          next.append(carry);
        }
        ternary = next.toString().toCharArray();
      }
      long result = 0L, three = 1;
      for (int i = 0; i < ternary.length; i++, three *= 3) {
        result += (ternary[i] - '0') * three;
      }
      out.println(result);
    }
  }

  private String ternary(long x) {
    if (x == 0) return "0";
    StringBuilder result = new StringBuilder();
    while (x > 0) {
      result.append(x % 3);
      x /= 3;
    }
    return result.toString();
  }

  private int rightMostTwo(char[] x) {
    for (int i = x.length - 1; i >= 0; i--) {
      if (x[i] == '2') {
        return i;
      }
    }
    return -1;
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
    try (GoodNumbers instance = new GoodNumbers()) {
      instance.solve();
    }
  }
}
