package codeforces.contests1401_1500.problemset1492;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class CardDeck implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[] x = new int[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
      }
      ArrayDeque<Integer> result = new ArrayDeque<>();
      ArrayDeque<Integer> deque = new ArrayDeque<>();
      deque.add(x[0]);
      int currentMax = x[0];
      for (int i = 1; i < n; i++) {
        if (x[i] < currentMax) {
          deque.addLast(x[i]);
        } else {
          while (deque.size() > 0) {
            result.addFirst(deque.pollLast());
          }
          deque.add(currentMax = x[i]);
        }
      }
      while (deque.size() > 0) {
        result.addFirst(deque.pollLast());
      }
      while (result.size() > 0) {
        out.print(result.pollFirst());
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
    try (CardDeck instance = new CardDeck()) {
      instance.solve();
    }
  }
}
