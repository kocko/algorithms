package codeforces.contests1301_1400.problemset1353;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ConstructingTheArray implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[] result = new int[n];
      PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
        int x = -Integer.compare(a[1] - a[0] + 1, b[1] - b[0] + 1);
        return x != 0 ? x : Integer.compare(a[0], b[0]);
      });
      queue.add(new int[]{0, n - 1});
      int counter = 1;
      while (queue.size() > 0) {
        int[] top = queue.poll();
        int right = top[1], left = top[0];
        int idx;
        if ((right - left + 1) % 2 == 1) {
          idx = (right + left) / 2;
        } else {
          idx = (right + left - 1) / 2;
        }
        result[idx] = counter++;

        if (left <= idx - 1) {
          queue.add(new int[]{left, idx - 1});
        }
        if (idx + 1 <= right) {
          queue.add(new int[]{idx + 1, right});
        }
      }
      for (int i = 0; i < n; i++) {
        out.print(result[i]);
        out.print(' ');
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
    try (ConstructingTheArray instance = new ConstructingTheArray()) {
      instance.solve();
    }
  }
}
