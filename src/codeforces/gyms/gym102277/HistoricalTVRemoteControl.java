package codeforces.gyms.gym102277;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class HistoricalTVRemoteControl implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    boolean[] broken = new boolean[10];
    for (int i = 0; i < n; i++) {
      broken[in.ni()] = true;
    }
    int channel = in.ni(), press = Integer.MAX_VALUE;
    for (int target = 0; target <= 999; target++) {
      if (ok(target, broken)) {
        press = min(press, abs(target - channel));
      }
    }
    out.println(press);
  }

  private boolean ok(int channel, boolean[] broken) {
    String value = String.valueOf(channel);
    boolean possible = true;
    for (char c : value.toCharArray()) {
      possible &= !broken[c - '0'];
    }
    return possible;
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
    try (HistoricalTVRemoteControl instance = new HistoricalTVRemoteControl()) {
      instance.solve();
    }
  }
}
