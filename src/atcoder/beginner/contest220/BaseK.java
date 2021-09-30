package atcoder.beginner.contest220;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class BaseK implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public BaseK() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int k = in.ni();
    char[] a = in.next().toCharArray();
    char[] b = in.next().toCharArray();
    long A = convertToDecimal(a, k), B = convertToDecimal(b, k);
    out.println(A * B);
  }

  private long convertToDecimal(char[] num, int base) {
    long result = 0;
    for (char c : num) {
      int digit = c - '0';
      result = (result * base + digit);
    }
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
    try (BaseK instance = new BaseK()) {
      instance.solve();
    }
  }
}
