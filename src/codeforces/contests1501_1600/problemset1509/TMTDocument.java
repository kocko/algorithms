package codeforces.contests1501_1600.problemset1509;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class TMTDocument implements Closeable {

  private final InputReader in = new InputReader(System.in);
  private final PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      char[] x = in.next().toCharArray();
      ArrayDeque<Integer> deque = new ArrayDeque<>();
      for (int i = 0; i < n; i++) {
        if (x[i] == 'T') {
          deque.add(i);
        }
      }
      boolean possible = true;
      for (int i = 0; i < n; i++) {
        if (x[i] == 'M') {
          if (deque.size() > 0) {
            int left = deque.pollFirst();
            possible &= left < i;
          } else {
            possible = false;
            break;
          }
          if (deque.size() > 0) {
            int right = deque.pollLast();
            possible &= right > i;
          } else {
            possible = false;
            break;
          }
        }
        if (!possible) break;
      }
      possible &= deque.size() == 0;
      out.println(possible ? "YES" : "NO");
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
    try (TMTDocument instance = new TMTDocument()) {
      instance.solve();
    }
  }
}
