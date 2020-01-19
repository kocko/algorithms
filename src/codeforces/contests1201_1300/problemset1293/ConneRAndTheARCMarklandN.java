package codeforces.contests1201_1300.problemset1293;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ConneRAndTheARCMarklandN implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), s = in.ni(), k = in.ni();
      int result = Integer.MAX_VALUE;
      Set<Integer> closed = new HashSet<>();
      for (int i = 0; i < k; i++) {
        int next = in.ni();
        closed.add(next);
      }
      for (int offset = 0; offset <= 1000; offset++) {
        if (s - offset >= 1 && !closed.contains(s - offset)) {
          result = offset;
          break;
        }
        if (s + offset <= n && !closed.contains(s + offset)) {
          result = offset;
          break;
        }
      }
      out.println(result);
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
    try (ConneRAndTheARCMarklandN instance = new ConneRAndTheARCMarklandN()) {
      instance.solve();
    }
  }
}
