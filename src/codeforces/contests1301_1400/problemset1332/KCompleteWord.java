package codeforces.contests1301_1400.problemset1332;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class KCompleteWord implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), k = in.ni();
      int half;
      if (k % 2 == 0) {
        half = k / 2 - 1;
      } else {
        half = k / 2;
      }
      int[] b = new int[n];
      for (int i = 0; i < n; i++) {
        int bucket = i % k;
        int match = k - bucket - 1;
        b[i] = Math.min(bucket, match);
      }
      char[] x = in.next().toCharArray();
      int[][] bucket = new int[half + 1][26];
      for (int idx = 0; idx < n; idx++) {
        char c = x[idx];
        bucket[b[idx]][c - 'a']++;
      }
      char[] best = new char[k];
      for (int i = 0; i <= half; i++) {
        int max = 0, idx = -1;
        for (int j = 0; j < 26; j++) {
          if (bucket[i][j] > max) {
            max = bucket[i][j];
            idx = j;
          }
        }
        best[i] = (char) ('a' + idx);
      }
      int result = 0;
      for (int i = 0; i < n; i++) {
        if (x[i] != best[b[i]]) {
          x[i] = best[b[i]];
          result++;
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
    try (KCompleteWord instance = new KCompleteWord()) {
      instance.solve();
    }
  }
}
