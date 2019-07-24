package codeforces.contests1101_1200.problemset1196;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class OddSumSegments implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int q = in.ni();
    while (q-- > 0) {
      int n = in.ni(), k = in.ni();
      long[] x = new long[n];
      long sum = 0;
      for (int i = 0; i < n; i++) {
        x[i] = in.nl();
        sum += x[i];
      }
      if (sum % 2 != k % 2) {
        out.println("NO");
      } else {
        ArrayDeque<Integer> result = new ArrayDeque<>();
        long current = 0;
        for (int i = 0; i < n; i++) {
          current += x[i];
          if (current % 2 == 1) {
            result.add(i + 1);
            current = 0;
          }
        }
        if (current > 0) {
          result.pollLast();
          result.add(n);
        }
        while (result.size() > k && result.size() >= 2) {
          result.pollFirst();
          result.pollFirst();
        }
        if (result.size() < k) {
          out.println("NO");
        } else {
          out.println("YES");
          while (result.size() > 0) {
            out.print(result.pollFirst());
            out.print(' ');
          }
          out.println();
        }
      }
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
    try (OddSumSegments instance = new OddSumSegments()) {
      instance.solve();
    }
  }
}
