package codeforces.contests1301_1400.problemset1399;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BoatsCompetition implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[] x = new int[n];
      int[] count = new int[101];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
        count[x[i]]++;
      }
      int result = 0;
      for (int weight = 1; weight <= 100; weight++) {
        int temp = 0;
        for (int first = 1; first <= 50; first++) {
          int second = weight - first;
          if (second >= first) {
            if (first == second) {
              temp += count[first] / 2;
            } else {
              temp += Math.min(count[first], count[second]);
            }
          } else break;
        }
        result = Math.max(result, temp);
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
    try (BoatsCompetition instance = new BoatsCompetition()) {
      instance.solve();
    }
  }
}
