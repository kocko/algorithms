package codeforces.contests1201_1300.problemset1256;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PlatformsJumping implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni(), d = in.ni();
    int[] c = new int[m];
    int total = 0;
    for (int i = 0; i < m; i++) {
      c[i] = in.ni();
      total += c[i];
    }
    int remaining = n - total, maxSize = remaining / (m + 1) + (remaining % (m + 1) != 0 ? 1 : 0);
    PriorityQueue<Integer> gaps = new PriorityQueue<>();
    for (int i = 0; i <= m; i++) {
      gaps.offer(maxSize);
      total += maxSize;
    }
    while (total > n) {
      int gap = gaps.peek();
      if (total - gap >= n) {
        total -= gaps.poll();
      } else if (total - gap < n) {
        int diff = total - n;
        gaps.poll();
        gaps.offer(gap - diff);
        total = n;
      }
    }
    boolean ok = true;
    int[] result = new int[n];
    int idx = 0;
    for (int i = 0; i < m; i++) {
      if (gaps.size() > 0) {
        int gap = gaps.poll();
        if (gap >= d) {
          ok = false;
          break;
        }
        for (int j = 0; j < gap; j++) {
          result[idx++] = 0;
        }
      }
      for (int j = 0; j < c[i]; j++) {
        result[idx++] = i + 1;
      }
    }
    if (gaps.size() > 0) {
      int gap = gaps.poll();
      if (gap >= d) {
        ok = false;
      }
      for (int j = 0; j < gap; j++) {
        result[idx++] = 0;
      }
    }
    if (ok) {
      out.println("YES");
      for (int i = 0; i < n; i++) {
        out.print(result[i]);
        out.print(' ');
      }
    } else {
      out.println("NO");
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
    try (PlatformsJumping instance = new PlatformsJumping()) {
      instance.solve();
    }
  }
}
