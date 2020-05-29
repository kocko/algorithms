package codeforces.gyms.gym100090;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class TheLastWish implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[] x = in.next().toCharArray();
    int n = x.length;
    boolean[] has = new boolean[26];
    for (int i = 0; i < n; i++) {
      has[x[i] - 'a'] = true;
    }
    ArrayDeque<Character> next = new ArrayDeque<>();
    for (int i = 0; i < 26; i++) {
      if (!has[i]) {
        next.addLast((char) ('a' + i));
      }
    }
    boolean[] seen = new boolean[26];
    boolean possible = true;
    for (int i = 0; i < n; i++) {
      if (!seen[x[i] - 'a']) {
        seen[x[i] - 'a'] = true;
      } else {
        if (next.size() > 0) {
          x[i] = next.pollFirst();
        } else {
          possible = false;
          break;
        }
      }
    }
    if (possible) {
      for (char c : x) {
        out.print(c);
      }
    } else {
      out.println("IMPOSSIBLE");
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
    try (TheLastWish instance = new TheLastWish()) {
      instance.solve();
    }
  }
}
