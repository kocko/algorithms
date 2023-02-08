package codeforces.contests1701_1800.problemset1742;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Coprime implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public Coprime() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    final int MAX_A = 1000;
    List<int[]> coprimes = new ArrayList<>();
    coprimes.add(new int[]{1, 1});
    for (int i = 1; i <= MAX_A; i++) {
      for (int j = i + 1; j <= MAX_A; j++) {
        if (gcd(i, j) == 1) {
          coprimes.add(new int[]{i, j});
        }
      }
    }
    while (T-- > 0) {
      int n = in.ni();
      int[] last = new int[MAX_A + 1];
      for (int i = 0; i < n; i++) {
        int next = in.ni();
        last[next] = i + 1;
      }
      int result = -1;
      for (int[] pair : coprimes) {
        if (last[pair[0]] > 0 && last[pair[1]] > 0) {
          result = Math.max(result, last[pair[0]] + last[pair[1]]);
        }
      }
      out.println(result);
    }
  }

  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
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
    try (Coprime instance = new Coprime()) {
      instance.solve();
    }
  }
}
