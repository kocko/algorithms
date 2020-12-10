package codeforces.gyms.gym102873;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SandasJob implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[] x = in.next().toCharArray();
    char[] y = in.next().toCharArray();
    ArrayDeque<Character> queue = new ArrayDeque<>();
    int carry = 0;
    int i = x.length - 1, j = y.length - 1;
    while (j >= 0) {
      int sum = y[j] - '0';
      int have = i >= 0 ? x[i] - '0' : 0;

      if (sum >= have + carry) {
        queue.add((char) ('0' + (sum - have - carry)));
        carry = 0;
      } else {
        queue.add((char) ('0' + (sum + 10 - have - carry)));
        carry = 1;
      }
      i--;
      j--;
    }
    while (queue.size() > 0 && queue.peekLast() == '0') {
      queue.pollLast();
    }
    char[] p = new char[queue.size()];
    int idx = 0;
    while (queue.size() > 0) {
      p[idx++] = queue.pollLast();
    }
    Arrays.sort(p);
    Arrays.sort(x);
    boolean possible = p.length == x.length;
    if (possible) {
      for (int k = 0; k < p.length; k++) {
        possible &= p[k] == x[k];
      }
    }
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
    try (SandasJob instance = new SandasJob()) {
      instance.solve();
    }
  }
}
