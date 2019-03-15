package codeforces.contests501_600.problemset557;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Comparator.naturalOrder;

public class ArthurAndTable implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] height = new int[n], cost = new int[n];
    int[] cnt = new int[201];
    for (int i = 0; i < n; i++) height[i] = in.ni();
    for (int i = 0; i < n; i++) {
      cost[i] = in.ni();
      cnt[cost[i]]++;
    }
    List<Leg> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(new Leg(height[i], cost[i]));
    }
    list.sort(naturalOrder());
    int[] prefix = new int[n];
    for (int i = 0; i < n; i++) {
      prefix[i] = list.get(i).cost;
      if (i > 0) {
        prefix[i] += prefix[i - 1];
      }
    }
    int result = Integer.MAX_VALUE;
    int start = 0;
    while (start < n) {
      int current = start > 0 ? prefix[start - 1] : 0;
      int end = start + 1;
      while (end < n && list.get(end).height == list.get(start).height) {
        end++;
      }
      int count = end - start;
      for (int i = start; i < end; i++) {
        cnt[list.get(i).cost]--;
      }
      int remaining = n - end;
      if (remaining >= count) {
        int remove = remaining - count + 1;
        for (int value = 1; value <= 200 && remove > 0; value++) {
          if (cnt[value] > 0) {
            int legs = Math.min(remove, cnt[value]);
            remove -= legs;
            current += legs * value;
          }
        }
      }
      if (current < result) {
        result = current;
      }
      start = end;
    }
    out.println(result);
  }

  private class Leg implements Comparable<Leg> {
    private int height, cost;

    private Leg(int height, int cost) {
      this.height = height;
      this.cost = cost;
    }

    @Override
    public int compareTo(Leg o) {
      int h = Integer.compare(o.height, height);
      return h != 0 ? h : Integer.compare(cost, o.cost);
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
    try (ArthurAndTable instance = new ArthurAndTable()) {
      instance.solve();
    }
  }
}
