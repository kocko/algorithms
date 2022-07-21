package codeforces.contests1701_1800.problemset1703;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class DoubleStrings implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      String[] x = new String[n];
      Set<String> set = new HashSet<>();
      for (int i = 0; i < n; i++) {
        x[i] = in.next();
        set.add(x[i]);
      }
      for (int i = 0; i < n; i++) {
        int result = 0;
        for (int prefix = 1; prefix < x[i].length(); prefix++) {
          if (set.contains(x[i].substring(0, prefix)) && set.contains(x[i].substring(prefix))) {
            result = 1;
            break;
          }
        }
        out.print(result);
      }
      out.println();
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
    try (DoubleStrings instance = new DoubleStrings()) {
      instance.solve();
    }
  }
}