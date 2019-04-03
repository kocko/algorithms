package codeforces.contests201_300.problemset298;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class FishWeight implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni(), k = in.ni();
    List<Integer> alice = new ArrayList<>(), bob = new ArrayList<>();
    for (int i = 0; i < n; i++) alice.add(in.ni());
    for (int i = 0; i < m; i++) bob.add(in.ni());
    alice.sort(Comparator.naturalOrder());
    bob.sort(Comparator.naturalOrder());
    boolean result = n > m;
    for (int i = n - 1, j = m - 1; i >= 0 && j >= 0; i--, j--) {
      if (alice.get(i) > bob.get(j)) {
        result = true;
        break;
      }
    }
    out.println(result ? "YES" : "NO");
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
    try (FishWeight instance = new FishWeight()) {
      instance.solve();
    }
  }
}
