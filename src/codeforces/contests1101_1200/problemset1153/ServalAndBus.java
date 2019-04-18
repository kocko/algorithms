package codeforces.contests1101_1200.problemset1153;

import java.io.*;
import java.util.StringTokenizer;

public class ServalAndBus implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), time = in.ni(), result = -1, minDiff = Integer.MAX_VALUE;
    for (int i = 1; i <= n; i++) {
      int from = in.ni(), interval = in.ni();
      int arrive;
      if (from >= time) {
        arrive = from;
      } else {
        int d = time - from;
        int k = d / interval + (d % interval != 0 ? 1 : 0);
        arrive = from + interval * k;
      }
      if (arrive - time < minDiff) {
        minDiff = arrive - time;
        result = i;
      }
    }
    out.println(result);
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
    try (ServalAndBus instance = new ServalAndBus()) {
      instance.solve();
    }
  }
}
