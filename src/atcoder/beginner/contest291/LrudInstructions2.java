package atcoder.beginner.contest291;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class LrudInstructions2 implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public LrudInstructions2() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int n = in.ni();
    char[] s = in.next().toCharArray();
    final Map<Character, int[]> DIR = Map.of(
      'R', new int[]{1,  0},
      'L', new int[]{-1,  0},
      'U', new int[]{0,  1},
      'D', new int[]{0,  -1}
    );
    int x = 0, y = 0;
    Set<String> visited = new HashSet<>();
    visited.add(enc(x, y));
    boolean result = false;
    for (char c : s) {
      int[] d = DIR.get(c);
      x += d[0];
      y += d[1];
      result |= (!visited.add(enc(x, y)));
    }
    out.println(result ? "Yes" : "No");
  }

  private String enc(int x, int y) {
    return x + "_" + y;
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
    try (LrudInstructions2 instance = new LrudInstructions2()) {
      instance.solve();
    }
  }
}
