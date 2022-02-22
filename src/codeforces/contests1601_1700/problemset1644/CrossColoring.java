package codeforces.contests1601_1700.problemset1644;

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

public class CrossColoring implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public CrossColoring() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int t = in.ni();
    final long MOD = 998244353;
    while (t-- > 0) {
      int n = in.ni(), m = in.ni(), k = in.ni(), q = in.ni();
      List<int[]> queries = new ArrayList<>();
      for (int i = 0; i < q; i++) {
        queries.add(new int[]{in.ni(), in.ni()});
      }
      Set<Integer> row = new HashSet<>(), col = new HashSet<>();
      long result = 1L;
      for (int i = q - 1; i >= 0; i--) {
        int[] query = queries.get(i);
        if (!(row.contains(query[0]) || col.size() == m) ||
            !(col.contains(query[1]) || row.size() == n)) {
          result = (result * k) % MOD;
          row.add(query[0]);
          col.add(query[1]);
        }
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
    try (CrossColoring instance = new CrossColoring()) {
      instance.solve();
    }
  }
}
