package codeforces.contests1201_1300.problemset1249;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BooksExchange implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      int[] p = new int[n];
      int[] day = new int[n];
      for (int i = 0; i < n; i++) {
        p[i] = in.ni();
        day[i] = -1;
      }
      for (int i = 1; i <= n; i++) {
        if (day[i - 1] == -1) {
          Set<Integer> mark = new HashSet<>();
          int current = i;
          while (true) {
            mark.add(current);
            int next = p[current - 1];
            if (mark.contains(next)) break;
            current = next;
          }
          int count = mark.size();
          for (int child : mark) {
            day[child - 1] = count;
          }
        }
      }
      for (int i = 0; i < n; i++) {
        out.print(day[i]);
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
    try (BooksExchange instance = new BooksExchange()) {
      instance.solve();
    }
  }
}
