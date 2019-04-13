package codeforces.gyms.gym100694;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SuperHyperMarket implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class Line {
    private int idx, people, a, b;

    private Line(int idx, int first) {
      this.idx = idx;
      a = first;
      people = 1;
    }

    private double score() {
      return people == 1 ? a : people * (a + b) / 2.;
    }

    private void add(int products) {
      if (b == 0) {
        b = products;
      } else {
        a = b;
        b = products;
      }
      people++;
    }
  }

  public void solve() {
    int n = in.ni(), k = in.ni();
    int[] p = new int[n];
    for (int i = 0; i < n; i++) {
      p[i] = in.ni();
    }
    PriorityQueue<Line> queue = new PriorityQueue<>(Comparator.comparingDouble(Line::score).thenComparing(x -> x.idx));
    int idx = 1;
    for (int i = 0; i < n; i++) {
      Line line;
      if (queue.size() < k) {
        line = new Line(idx++, p[i]);
      } else {
        line = queue.poll();
        line.add(p[i]);
      }
      queue.offer(line);
      out.print(line.idx);
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
    try (SuperHyperMarket instance = new SuperHyperMarket()) {
      instance.solve();
    }
  }
}
