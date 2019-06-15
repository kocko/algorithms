package codeforces.contests301_400.problemset304;

import java.io.*;
import java.util.StringTokenizer;

public class LuckyPermutationTriple implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    if (n % 2 == 1) {
      int[] a = new int[n], b = new int[n], c = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = n - i - 1;
        c[i] = i;
      }
      for (int i = 0; i < n; i++) {
        if (c[i] >= a[i]) {
          b[i] = c[i] - a[i];
        } else {
          b[i] = n - a[i] + c[i];
        }
      }
      print(a);
      print(b);
      print(c);
    } else {
      out.println(-1);
    }
  }
  
  private void print(int[] x) {
    for (int value : x) {
      out.print(value);
      out.print(' ');
    }
    out.println();
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
    try (LuckyPermutationTriple instance = new LuckyPermutationTriple()) {
      instance.solve();
    }
  }
}
