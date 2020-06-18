package codeforces.contests1301_1400.problemset1368;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EvenPicture implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    List<int[]> result = new ArrayList<>();
    result.add(new int[]{0, 0});
    result.add(new int[]{0, 1});
    result.add(new int[]{1, 0});
    result.add(new int[]{1, 1});
    result.add(new int[]{1, 2});
    result.add(new int[]{2, 1});
    result.add(new int[]{2, 2});
    int x = 2, y = 2;
    for (int i = 1; i < n; i++, x++, y++) {
      result.add(new int[]{x + 1, y});
      result.add(new int[]{x, y + 1});
      result.add(new int[]{x + 1, y + 1});
    }
    out.println(result.size());
    for (int[] point : result) {
      out.println(point[0] + " " + point[1]);
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
    try (EvenPicture instance = new EvenPicture()) {
      instance.solve();
    }
  }
}
