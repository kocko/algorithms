package codeforces.contests1601_1700.problemset1638;

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

import static java.lang.Math.*;

public class OddSwapSort implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public OddSwapSort() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int lastEven = -1, lastOdd = -1;
      boolean can = true;
      for (int i = 0; i < n; i++) {
        int next = in.ni();
        if (next % 2 == 0) {
          can &= lastEven <= next;
          lastEven = next;
        } else {
          can &= lastOdd <= next;
          lastOdd = next;
        }
      }
      out.println(can ? "Yes" : "No");
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
    try (OddSwapSort instance = new OddSwapSort()) {
      instance.solve();
    }
  }
}
