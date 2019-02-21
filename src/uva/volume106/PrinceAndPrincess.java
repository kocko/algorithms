package uva.volume106;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class PrinceAndPrincess implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int tests = in.ni();
    for (int testCase = 1; testCase <= tests; testCase++) {
      int n = in.ni(), p = in.ni(), q = in.ni();
      int[] a = new int[p + 1], b = new int[q + 1];
      Map<Integer, Integer> prince = new HashMap<>();
      for (int i = 0; i < p + 1; i++) {
        prince.put(in.ni(), i);
      }
      List<Integer> princess = new ArrayList<>();
      for (int i = 0; i < q + 1; i++) {
        int next = in.ni();
        if (prince.containsKey(next)) {
          princess.add(prince.get(next));
        }
      }
      out.printf("Case %d: %d\n", testCase, lis(princess));
    }
  }

  private int lis(List<Integer> list) {
    int[] tails = new int[list.size()];
    int size = 0;
    for (int x : list) {
      int i = 0, j = size;
      while (i != j) {
        int m = (i + j) / 2;
        if (tails[m] < x)
          i = m + 1;
        else
          j = m;
      }
      tails[i] = x;
      if (i == size) ++size;
    }
    return size;
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
    try (PrinceAndPrincess instance = new PrinceAndPrincess()) {
      instance.solve();
    }
  }
}
