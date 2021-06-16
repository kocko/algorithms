package codeforces.contests1501_1600.problemset1534;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class LittleAlawnsPuzzle implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public LittleAlawnsPuzzle() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public LittleAlawnsPuzzle(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[] a = new int[n], b = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.ni();
      }
      int[] pos = new int[n + 1];
      for (int i = 0; i < n; i++) {
        b[i] = in.ni();
        pos[b[i]] = i;
      }
      int cycles = 0;
      boolean[] visited = new boolean[n + 1];
      for (int i = 0; i < n; i++) {
        if (!visited[i]) {
          cycles++;
          int next = pos[a[i]];
          while (next != i) {
            visited[next] = true;
            next = pos[a[next]];
          }
        }
      }
      out.println(power(cycles));
    }
  }

  private final long MOD = (long) 1e9 + 7;

  private long power(int exp) {
    if (exp == 0) return 1L;
    if (exp == 1) return 2L;

    long half = power(exp / 2);
    long result = half * half % MOD;
    if (exp % 2 == 1) {
      result *= 2;
      result %= MOD;
    }
    return result;
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
    try (LittleAlawnsPuzzle instance = new LittleAlawnsPuzzle()) {
      instance.solve();
    }
  }
}
