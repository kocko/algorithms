package codeforces.contests1201_1300.problemset1216;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Shooting implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  class Can implements Comparable<Can> {
    private int idx;
    private long durability;

    Can(int idx, long durability) {
      this.idx = idx;
      this.durability = durability;
    }

    @Override
    public int compareTo(Can o) {
      return Long.compare(this.durability, o.durability);
    }
  }

  public void solve() {
    int n = in.ni();
    List<Can> x = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      x.add(new Can(i, in.ni()));
    }
    x.sort(Comparator.reverseOrder());
    long total = 0;
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      total += i * x.get(i).durability + 1;
      result[i] = x.get(i).idx + 1;
    }

    out.println(total);
    for (int i = 0; i < n; i++) {
      out.print(result[i]);
      out.print(' ');
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
    try (Shooting instance = new Shooting()) {
      instance.solve();
    }
  }
}
