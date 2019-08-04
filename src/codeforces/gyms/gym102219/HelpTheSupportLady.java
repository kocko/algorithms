package codeforces.gyms.gym102219;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class HelpTheSupportLady implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    for (int test = 1; test <= T; test++) {
      int n = in.ni();
      List<Long> tasks = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        tasks.add(in.nl() << 1);
      }
      tasks.sort(Comparator.naturalOrder());
      long currentTime = 0, result = 0;
      for (int i = 0; i < n; i++) {
        long deadline = tasks.get(i);
        if (currentTime * 2 <= deadline) {
          result++;
          currentTime += deadline / 2;
        }
      }
      out.printf("Case #%d: %d\n", test, result);
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
    try (HelpTheSupportLady instance = new HelpTheSupportLady()) {
      instance.solve();
    }
  }
}
