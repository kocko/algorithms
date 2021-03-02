package codeforces.contests1401_1500.problemset1494;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class ABCString implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      char[] x = in.next().toCharArray();
      boolean possible = false;
      for (int a : new int[]{-1, 1}) for (int b : new int[]{-1, 1}) for (int c : new int[]{-1, 1}) {
        if (ok(x, a, b, c)) {
          possible = true;
        }
      }
      out.println(possible ? "YES" : "NO");
    }
  }

  private boolean ok(char[] x, int ... p) {
    boolean possible = true;
    int balance = 0;
    for (char c : x) {
      balance += p[c - 'A'];
      if (balance < 0) {
        possible = false;
      }
    }
    possible &= balance == 0;
    return possible;
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
    try (ABCString instance = new ABCString()) {
      instance.solve();
    }
  }
}
