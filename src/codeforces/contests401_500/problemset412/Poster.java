package codeforces.contests401_500.problemset412;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Poster implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    pos = in.ni();
    x = in.next().toCharArray();
    int start, step;
    String move;
    if (pos - 1 <= n - pos) {
      shift("LEFT", pos - 1);
      start = 0;
      step = 1;
      move = "RIGHT";
    } else {
      shift("RIGHT", n - pos);
      start = n - 1;
      step = -1;
      move = "LEFT";
    }
    complete(start, step, move);
  }

  private int n, pos;
  private char[] x;

  private void shift(String command, int times) {
    for (int i = 0; i < times; i++) {
      out.println(command);
    }
  }

  private void complete(int start, int step, String move) {
    int printed = 0;
    for (int i = start; ; i += step) {
      if (i < 0 || i == n) break;
      out.println("PRINT " + x[i]);
      printed++;
      if (printed < n) {
        out.println(move);
      }
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
    try (Poster instance = new Poster()) {
      instance.solve();
    }
  }
}
