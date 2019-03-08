package codeforces.contests1101_1200.problemset1133;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ZeroQuantityMaximization implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] a  = new int[n], b = new int[n];
    for (int i = 0; i < n; i++) a[i] = in.ni();
    for (int i = 0; i < n; i++) b[i] = in.ni();
    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    int max = 0, pairs = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] == 0 && b[i] == 0) pairs++;
      else if (a[i] != 0) {
        int gcd = gcd(a[i], b[i]);
        a[i] /= gcd;
        b[i] /= gcd;
        Map<Integer, Integer> mp = map.getOrDefault(-b[i], new HashMap<>());
        int cnt = mp.getOrDefault(a[i], 0) + 1;
        mp.put(a[i], cnt);
        if (cnt > max) {
          max = cnt;
        }
        map.put(-b[i], mp);
      }
    }
    out.println(max + pairs);
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
    try (ZeroQuantityMaximization instance = new ZeroQuantityMaximization()) {
      instance.solve();
    }
  }
}
