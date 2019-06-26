package codeforces.contests1101_1200.problemset1183;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Comparator.reverseOrder;

public class CandyBoxEasy implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int q = in.ni();
    while (q-- > 0) {
      List<Integer> candies = new ArrayList<>();
      int n = in.ni();
      int[] count = new int[n + 1];
      for (int i = 0; i < n; i++) {
        count[in.ni()]++;
      }
      for (int i = 1; i <= n; i++) {
        if (count[i] > 0) {
          candies.add(count[i]);
        }
      }
      candies.sort(reverseOrder());
      int result = candies.get(0), last = result;
      for (int i = 1; i < candies.size(); i++) {
        if (last == 0) break;
        int current = candies.get(i);
        if (current >= last - 1) {
          result += last - 1;
          last--;
        } else {
          result += current;
          last = current;
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
    try (CandyBoxEasy instance = new CandyBoxEasy()) {
      instance.solve();
    }
  }
}
