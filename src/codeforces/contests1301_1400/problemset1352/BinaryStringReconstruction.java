package codeforces.contests1301_1400.problemset1352;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BinaryStringReconstruction implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int zero = in.ni(), one = in.ni(), two = in.ni();
      StringBuilder sb = new StringBuilder();
      if (one == 0) {
        int digit = zero > 0 ? 0 : 1;
        for (int i = 0; i <= Math.max(zero, two); i++) {
          sb.append(digit);
        }
        out.println(sb);
      } else {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(1);
        queue.addLast(0);
        one--;
        for (int i = 0; i < zero; i++) {
          queue.addLast(0);
        }
        int next = 1, last = 0;
        while (one > 0) {
          queue.addLast(next);
          last = next;
          next ^= 1;
          one--;
        }
        for (int i = 0; i < two; i++) {
          if (last == 1) {
            queue.addLast(1);
          } else {
            queue.addFirst(1);
          }
        }
        while (queue.size() > 0) {
          out.print(queue.pollFirst());
        }
        out.println();
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
    try (BinaryStringReconstruction instance = new BinaryStringReconstruction()) {
      instance.solve();
    }
  }
}
