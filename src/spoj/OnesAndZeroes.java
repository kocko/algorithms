package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class OnesAndZeroes implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      go(n);
    }
  }

  private void go(int n) {
    ArrayDeque<Vertex> queue = new ArrayDeque<>();
    queue.add(new Vertex("1", 1));
    Set<Integer> has = new HashSet<>();
    has.add(1);
    while (queue.size() > 0) {
      Vertex top = queue.pollFirst();
      int rem = top.rem;
      for (int digit : new int[]{0, 1}) {
        int nextRem = (rem * 10 + digit) % n;
        if (nextRem == 0) {
          out.println(top.s + "" + digit);
          return;
        }
        if (!has.contains(nextRem)) {
          queue.add(new Vertex(top.s + "" + digit, nextRem));
          has.add(nextRem);
        }
      }
    }
  }

  private class Vertex {
    private String s;
    private int rem;

    private Vertex(String s, int rem) {
      this.s = s;
      this.rem = rem;
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
    try (OnesAndZeroes instance = new OnesAndZeroes()) {
      instance.solve();
    }
  }
}
