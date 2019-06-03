package codeforces.contests1101_1200.problemset1155;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class GameWithTelephoneNumbers implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    char[] x = in.next().toCharArray();
    ArrayDeque<Integer> eights = new ArrayDeque<>();
    ArrayDeque<Integer> others = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      if (x[i] == '8') {
        eights.addLast(i);
      } else {
        others.addLast(i);
      }
    }
    boolean vasya = true, possible = true;
    int digits = n;
    while (digits > 11) {
      if (vasya) {
        if (others.size() > 0) {
          others.pollFirst();
        } else {
          eights.pollLast();
        }
      } else {
        if (eights.size() > 0) {
          eights.pollFirst();
        } else {
          possible = false;
          break;
        }
      }
      vasya = !vasya;
      digits--;
    }
    possible &= eights.size() > 0 && eights.peekFirst() <= n - 11;
    out.println(possible ? "YES" : "NO");
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
    try (GameWithTelephoneNumbers instance = new GameWithTelephoneNumbers()) {
      instance.solve();
    }
  }
}
