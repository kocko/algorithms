package codeforces.gyms.gym101311;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MagicWeapon implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int a = in.ni(), b = in.ni(), c = in.ni();
    long[] A = new long[10];
    long[][] B = new long[10][10];
    long[] C = new long[10];
    Map<Integer, Long> L = new HashMap<>(), R = new HashMap<>(), S = new HashMap<>();
    for (int i = 0; i < a; i++) {
      int next = in.ni();
      A[getFirst(next)]++;
      L.put(next, L.getOrDefault(next, 0L) + 1);
    }
    for (int i = 0; i < b; i++) {
      int next = in.ni();
      B[getLast(next)][getFirst(next)]++;
      S.put(next, S.getOrDefault(next, 0L) + 1);
    }
    for (int i = 0; i < c; i++) {
      int next = in.ni();
      C[getLast(next)]++;
      R.put(next, R.getOrDefault(next, 0L) + 1);
    }
    long result = 0;
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        result += A[i] * B[i][j] * C[j];
      }
    }
    for (Map.Entry<Integer, Long> entry : L.entrySet()) {
      int key = entry.getKey();
      long count = entry.getValue();
      if (getLast(key) == getFirst(key)) {
        result -= count * S.getOrDefault(key, 0L) * C[getFirst(key)];
        result += 2L * count * S.getOrDefault(key, 0L) * R.getOrDefault(key, 0L);
      }
      result -= count * R.getOrDefault(key, 0L) * B[getFirst(key)][getLast(key)];
    }
    for (Map.Entry<Integer, Long> entry : S.entrySet()) {
      int key = entry.getKey();
      long count = entry.getValue();
      if (getLast(key) == getFirst(key)) {
        result -= count * A[getLast(key)] * R.getOrDefault(key, 0L);
      }
    }
    out.println(result);
  }

  private int getFirst(int x) {
    return x % 10;
  }

  private int getLast(int x) {
    while (x >= 10) {
      x /= 10;
    }
    return x;
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
    try (MagicWeapon instance = new MagicWeapon()) {
      instance.solve();
    }
  }
}
