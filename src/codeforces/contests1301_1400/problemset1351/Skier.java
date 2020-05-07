package codeforces.contests1301_1400.problemset1351;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class Skier implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      char[] path = in.next().toCharArray();
      Set<String> seen = new HashSet<>();
      int result = 0;
      int x = 0, y = 0;
      for (int i = 0; i < path.length; i++) {
        char step = path[i];
        int px = x, py = y;
        switch (step) {
          case 'N': { px++; break; }
          case 'S': { px--; break; }
          case 'W': { py--; break; }
          case 'E': { py++; break; }
        }
        String key = String.format("%d_%d_%d_%d", min(x, px), max(x, px), min(y, py), max(y, py));
        if (seen.contains(key)) {
          result++;
        } else {
          result += 5;
          seen.add(key);
        }
        x = px;
        y = py;
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
    try (Skier instance = new Skier()) {
      instance.solve();
    }
  }
}
