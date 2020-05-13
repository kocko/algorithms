package atcoder.beginner.contest166;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ThisMessageWillSelfDestructIn5s implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] h = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      h[i] = in.ni();
    }
    long result = 0;
    Map<Integer, Long> back = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      int score = h[i] - i;
      long same = back.getOrDefault(score, 0L);
      result += same;
      back.put(-(i + h[i]), back.getOrDefault(-(i + h[i]), 0L) + 1);
    }

    Map<Integer, Long> front = new HashMap<>();
    for (int i = n; i >= 1; i--) {
      int score = h[i] + i;
      long same = front.getOrDefault(score, 0L);
      result += same;
      front.put(i - h[i], front.getOrDefault(i - h[i], 0L) + 1);
    }
    out.println(result >> 1);
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
    try (ThisMessageWillSelfDestructIn5s instance = new ThisMessageWillSelfDestructIn5s()) {
      instance.solve();
    }
  }
}
