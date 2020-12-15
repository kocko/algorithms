package codeforces.contests1401_1500.problemset1462;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class AddToNeighbourAndRemove implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      long[] x = new long[n];
      long sum = 0;
      Set<Long> prefixes = new HashSet<>();
      for (int i = 0; i < n; i++) {
        x[i] = in.nl();
        sum += x[i];
        prefixes.add(sum);
      }
      long prefix = 0, result = n;
      for (int i = 0; i < n; i++) {
        prefix += x[i];
        if (sum % prefix == 0) {
          boolean ok = true;
          int times;
          int count = 0;
          for (times = 1; times * prefix <= sum && ok; times++) {
            ok = prefixes.contains(times * prefix);
            count++;
          }
          if (ok) {
            result = n - count;
            break;
          }
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
    try (AddToNeighbourAndRemove instance = new AddToNeighbourAndRemove()) {
      instance.solve();
    }
  }
}
