package codeforces.contests1601_1700.problemset1650;

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

public class TwistThePermutation implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public TwistThePermutation() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      ArrayDeque<Integer> deque = new ArrayDeque<>();
      for (int i = 0; i < n; i++) {
        deque.add(in.ni());
      }
      int[] result = new int[n + 1];
      int target = n;
      while (target > 0) {
        int steps = 0;
        while (deque.peekLast() != target) {
          deque.addLast(deque.pollFirst());
          steps++;
        }
        deque.pollLast();
        result[target] = steps;
        target--;
      }
      for (int i = 1; i <= n; i++) {
        out.print(result[i]);
        out.print(' ');
      }
      out.println();
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
    try (TwistThePermutation instance = new TwistThePermutation()) {
      instance.solve();
    }
  }
}
