package codeforces.contests1501_1600.problemset1538;

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

public class FriendsAndCandies implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public FriendsAndCandies() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public FriendsAndCandies(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[] x = new int[n];
      int total = 0;
      for (int i = 0; i < n; i++) {
        x[i] =  in.ni();
        total += x[i];
      }
      if (total % n != 0) {
        out.println(-1);
        continue;
      }
      int fair = total / n, result = 0;
      for (int i = 0; i < n; i++) {
        if (x[i] > fair) {
          result++;
        }
      }
      out.println(result);
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
    try (FriendsAndCandies instance = new FriendsAndCandies()) {
      instance.solve();
    }
  }
}
