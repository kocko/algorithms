package codeforces.contests401_500.problemset432;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class PrimeSwaps implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    fill();
    int n = in.ni();
    x = new int[n];
    pos = new int[n];
    for (int i = 0; i < n; i++) {
      pos[x[i] = in.ni() - 1] = i;
    }
    for (int i = 0; i < n; i++) {
      while (pos[i] != i) {
        int to = pos[i];
        int dist = abs(i - to) + 1;
        if (prime[dist]) {
          swap(i, to);
        } else {
          if (i < to) {
            swap(pos[i], pos[i] - previous[dist - 1] + 1);
          } else {
            swap(pos[i], pos[i] + previous[dist - 1] - 1);
          }
        }
      }
    }
    out.println(swaps.size());
    for (int[] swap : swaps) {
      out.println((swap[0] + 1) + " " + (swap[1] + 1));
    }
  }

  private final int MAX_N = (int) 1e5;
  private int[] x, pos;
  private boolean[] prime = new boolean[MAX_N + 1];
  private int[] previous = new int[MAX_N + 1];

  private void fill() {
    Arrays.fill(prime, true);
    prime[0] = prime[1] = false;
    for (int i = 2; i <= MAX_N; i++) {
      if (prime[i]) {
        for (long j = (long) i * i; j <= MAX_N; j += i) {
          prime[(int) j] = false;
        }
      }
    }
    int prev = 1;
    for (int i = 2; i <= MAX_N; i++) {
      previous[i] = prev;
      if (prime[i]) {
        prev = i;
      }
    }
  }

  private List<int[]> swaps = new ArrayList<>();

  private void swap(int from, int to) {
    swaps.add(new int[]{min(from, to), max(from, to)});
    x[from] = x[to] ^ x[from] ^ (x[to] = x[from]);
    pos[x[from]] = pos[x[to]] ^ pos[x[from]] ^ (pos[x[to]] = pos[x[from]]);
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
    try (PrimeSwaps instance = new PrimeSwaps()) {
      instance.solve();
    }
  }
}
