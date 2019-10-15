package codeforces.contests1201_1300.problemset1238;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class KillEmAll implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int q = in.ni();
    while (q-- > 0) {
      int n = in.ni(), r = in.ni();
      int max = 0;
      int[] x = new int[n];
      Set<Integer> unique = new TreeSet<>();
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
        if (x[i] > max) {
          max = x[i];
        }
        unique.add(x[i]);
      }
      List<Integer> monsters = new ArrayList<>(unique);
      int kills = 1;
      for (int i = monsters.size() - 1; i >= 1; i--, kills++) {
        if (kills * r >= monsters.get(i - 1)) {
          break;
        }
      }
      out.println(kills);
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
    try (KillEmAll instance = new KillEmAll()) {
      instance.solve();
    }
  }
}
