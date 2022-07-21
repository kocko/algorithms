package codeforces.contests1701_1800.problemset1703;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class YetAnotherProblemAboutPairsSatisfyingAnInequality implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      int[] x = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        x[i] = in.ni();
      }
      long bigger = 0, result = 0;
      PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
      for (int i = n; i > 0; i--) {
        if (x[i] < i) {
          while (queue.size() > 0 && queue.peek() > i) {
            queue.poll();
            bigger++;
          }
          result += bigger;
          queue.add(x[i]);
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
    try (YetAnotherProblemAboutPairsSatisfyingAnInequality instance = new YetAnotherProblemAboutPairsSatisfyingAnInequality()) {
      instance.solve();
    }
  }
}