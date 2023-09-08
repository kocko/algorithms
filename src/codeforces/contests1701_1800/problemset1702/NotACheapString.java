package codeforces.contests1701_1800.problemset1702;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class NotACheapString implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public NotACheapString() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      char[] x = in.next().toCharArray();
      int n = x.length;
      boolean[] removed = new boolean[n];
      int p = in.ni();
      int sum = 0;
      PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(arr -> -arr[0]));
      for (int idx = 0; idx < n; idx++) {
        char c = x[idx];
        queue.add(new int[]{c - 'a' + 1, idx});
        sum += (c - 'a' + 1);
      }
      while (sum > p) {
        int[] next = queue.poll();
        sum -= next[0];
        removed[next[1]] = true;
      }
      for (int i = 0; i < n; i++) {
        if (!removed[i]) {
          out.print(x[i]);
        }
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
    try (NotACheapString instance = new NotACheapString()) {
      instance.solve();
    }
  }
}
