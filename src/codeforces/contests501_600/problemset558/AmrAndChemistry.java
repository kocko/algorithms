package codeforces.contests501_600.problemset558;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class AmrAndChemistry implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    final int MAX_N = (int) 1e5;
    int[] reachableBy = new int[MAX_N + 1];
    int[] score = new int[MAX_N + 1];
    int[] visited = new int[MAX_N + 1];

    for (int i = 1; i <= n; i++) {
      int value = in.ni();

      ArrayDeque<int[]> queue = new ArrayDeque<>();
      queue.offerLast(new int[]{value, 0});

      while (queue.size() > 0) {
        int[] top = queue.pollFirst();
        if (top[0] > MAX_N) continue;
        if (visited[top[0]] == i) continue;
        visited[top[0]] = i;
        score[top[0]] += top[1];
        reachableBy[top[0]]++;
        queue.offerLast(new int[]{top[0] / 2, top[1] + 1});
        queue.offerLast(new int[]{top[0] * 2, top[1] + 1});
      }

    }
    int result = Integer.MAX_VALUE;
    for (int i = 1; i <= MAX_N; i++) {
      if (reachableBy[i] == n && score[i] < result) {
        result = score[i];
      }
    }
    out.println(result);
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
    try (AmrAndChemistry instance = new AmrAndChemistry()) {
      instance.solve();
    }
  }
}
