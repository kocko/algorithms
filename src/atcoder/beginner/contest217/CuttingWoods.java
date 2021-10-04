package atcoder.beginner.contest217;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CuttingWoods implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public CuttingWoods() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int L = in.ni(), q = in.ni();
    TreeSet<Integer> set = new TreeSet<>();
    set.add(0);
    set.add(L);
    while (q-- > 0) {
      int type = in.ni();
      int x = in.ni();
      if (type == 1) {
        set.add(x);
      } else {
        int left = set.floor(x - 1);
        int right = set.ceiling(x + 1);
        out.println(right - left);
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
    try (CuttingWoods instance = new CuttingWoods()) {
      instance.solve();
    }
  }
}
