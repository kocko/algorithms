package codeforces.contests1501_1600.problemset1593;

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

public class MakeItDivisibleBy25 implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public MakeItDivisibleBy25() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public MakeItDivisibleBy25(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int t = in.ni();
    final String[] targets = {"25", "50", "75", "00"};
    while (t-- > 0) {
      char[] x = in.next().toCharArray();
      int result = x.length;
      for (String target : targets) {
        int cost = go(x, target.toCharArray());
        if (cost < result) {
          result = cost;
        }
      }
      out.println(result);
    }
  }

  private int go(char[] x, char[] target) {
    int result = 0;
    int i = x.length - 1, j = target.length - 1;
    while (i >= 0 && j >= 0) {
      if (x[i] == target[j]) {
        i--;
        j--;
      } else {
        result++;
        i--;
      }
    }
    return (i < 0 && j >= 0) ? 100 : result;
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
    try (MakeItDivisibleBy25 instance = new MakeItDivisibleBy25()) {
      instance.solve();
    }
  }
}
