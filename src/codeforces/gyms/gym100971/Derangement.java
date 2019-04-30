package codeforces.gyms.gym100971;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Derangement implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] x = new int[n];
    ArrayDeque<Integer> fixed = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      x[i] = in.ni() - 1;
      if (x[i] == i) {
        fixed.add(x[i]);
      }
    }
    int pairs = fixed.size() / 2;
    int ans = pairs + (fixed.size() % 2);
    out.println(ans);
    for (int i = 0; i < pairs; i++) {
      int a = fixed.pollFirst() + 1, b = fixed.pollFirst() + 1;
      out.println(a + " " + b);
    }
    if (fixed.size() % 2 == 1) {
      int last = fixed.pollFirst() + 1;
      int next = last + 1;
      if (next > n) next -= n;
      out.println(last + " " + next);
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
    try (Derangement instance = new Derangement()) {
      instance.solve();
    }
  }
}
