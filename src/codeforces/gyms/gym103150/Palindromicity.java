package codeforces.gyms.gym103150;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Palindromicity implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public Palindromicity() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public Palindromicity(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      out.println(solve(n));
    }
  }

  private int f(int n) {
    return n * (n + 1) / 2;
  }

  private String solve(int n) {
    StringBuilder result = new StringBuilder();
    char nextLetter = 'a';
    while (n > 0) {
      int biggest = findBiggestKFor(n);
      int score = biggest * (biggest + 1) / 2;
      n -= score;
      while (biggest > 0) {
        result.append(nextLetter);
        biggest--;
      }
      int p = (nextLetter - 'a' + 1) % 26;
      nextLetter = (char) ('a' + p);
    }
    return result.toString();
  }

  private int findBiggestKFor(int n) {
    if (n == 1) return 1;
    int left = 1, right = n;
    int result = 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (mid * (mid + 1) <= n * 2) {
        result = Math.max(result, mid);
        left = mid + 1;
      } else {
        right = mid - 1;
      }
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
    try (Palindromicity instance = new Palindromicity()) {
      instance.solve();
    }
  }
}