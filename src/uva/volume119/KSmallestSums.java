package uva.volume119;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class KSmallestSums implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public KSmallestSums() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    while (true) {
      try {
        int k = in.ni();
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
          result[i] = in.ni();
        }
        Arrays.sort(result);
        for (int i = 1; i < k; i++) {
          int[] next = new int[k];
          for (int j = 0; j < k; j++) {
            next[j] = in.ni();
          }
          Arrays.sort(next);
          result = merge(result, next);
        }
        for (int i = 0; i < k; i++) {
          out.print(result[i]);
          if (i < k - 1) {
            out.print(' ');
          }
        }
        out.println();
      } catch (Exception e) {
        break;
      }
    }
  }

  private int[] merge(int[] a, int[] b) {
    int k = a.length;
    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[0]));
    for (int i = 0; i < k; i++) {
      queue.add(new int[]{a[i] + b[0], 0});
    }
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      int[] top = queue.poll();
      result[i] = top[0];
      if (top[1] + 1 < k) {
        queue.offer(new int[]{top[0] - b[top[1]] + b[top[1] + 1], top[1] + 1});
      }
    }
    return result;
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

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    try (KSmallestSums instance = new KSmallestSums()) {
      instance.solve();
    }
  }
}
