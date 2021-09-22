package atcoder.beginner.contest212;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class GreedyTakahashi implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public GreedyTakahashi() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public GreedyTakahashi(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  private interface Range {
    int getStart();
    int getEnd();
    String getLocation();
    int getIndex();
  }

  private class Edge implements Comparable<Edge>, Range {
    private int idx, from, to, start, end;

    private Edge(int idx, int from, int to, int start, int end) {
      this.idx = idx;
      this.from = from;
      this.to = to;
      this.start = start;
      this.end = end;
    }

    @Override
    public int getStart() {
      return start;
    }

    @Override
    public int getEnd() {
      return end;
    }

    @Override
    public String getLocation() {
      return (from + 1) + " " + (to + 1);
    }

    @Override
    public int getIndex() {
      return idx;
    }

    @Override
    public int compareTo(Edge edge) {
      return Integer.compare(this.start, edge.start);
    }

  }

  private class Interval implements Comparable<Interval>, Range {
    private int vertex, start, end, idx;

    private Interval(int vertex, int start, int end, int idx) {
      this.vertex = vertex;
      this.start = start;
      this.end = end;
      this.idx = idx;
    }

    @Override
    public int getStart() {
      return start;
    }

    @Override
    public int getEnd() {
      return end;
    }

    @Override
    public String getLocation() {
      return String.valueOf(vertex + 1);
    }

    @Override
    public int getIndex() {
      return idx;
    }

    @Override
    public int compareTo(Interval interval) {
      return Integer.compare(this.start, interval.start);
    }

    @Override
    public String toString() {
      return "Interval{" +
          "vertex=" + vertex +
          ", start=" + start +
          ", end=" + end +
          '}';
    }
  }

  public void solve() {
    int n = in.ni(), m = in.ni(), q = in.ni();
    List<List<Edge>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    int idx = 0;
    for (int i = 0; i < m; i++) {
      int u = in.ni() - 1, v = in.ni() - 1, start = in.ni(), end = in.ni();
      graph.get(u).add(new Edge(idx++, u, v, start + 1, end));
    }
    for (int i = 0; i < n; i++) {
      graph.get(i).sort(Comparator.naturalOrder());
    }
    List<Interval> allIntervals = new ArrayList<>();
    List<List<Interval>> intervalsByCity = new ArrayList<>();
    //split each node into intervals
    {
      final int oo = (int) 2e9;
      for (int i = 0; i < n; i++) {
        intervalsByCity.add(new ArrayList<>());
        int start = 0;
        for (Edge edge : graph.get(i)) {
          Interval interval = new Interval(i, start, edge.start - 1, idx++);
          intervalsByCity.get(i).add(interval);
          allIntervals.add(interval);
          start = edge.start;
        }
        Interval interval = new Interval(i, start, oo, idx++);
        intervalsByCity.get(i).add(interval);
        allIntervals.add(interval);
        intervalsByCity.get(i).sort(Comparator.naturalOrder());
      }
    }
    int[] degree = new int[idx];
    Range[] nxt = new Range[idx];
    //build DAG
    {
      for (int u = 0; u < n; u++) {
        int next = 0;
        for (Edge edge : graph.get(u)) {
          Interval start = intervalsByCity.get(u).get(next++);
          int arrivalTime = edge.end;
          List<Interval> intervals = intervalsByCity.get(edge.to);
          int left = 0, right = intervals.size() - 1;
          Interval finish = start;
          while (left <= right) {
            int index = (left + right) / 2;
            Interval mid = intervals.get(index);
            if (mid.start <= arrivalTime && arrivalTime <= mid.end) {
              finish = mid;
              break;
            } else if (mid.start > arrivalTime) {
              right = index - 1;
            } else {
              left = index + 1;
            }
          }
          nxt[start.idx] = edge;
          nxt[edge.idx] = finish;
          degree[edge.idx]++;
          degree[finish.idx]++;
        }
      }
    }
    //answer queries
    {
      ArrayDeque<Range> queue = new ArrayDeque<>();
      for (int i = m; i < idx; i++) {
        if (degree[i] == 0) {
          queue.add(allIntervals.get(i - m));
        }
      }
      List<List<Range>> chains = new ArrayList<>();
      int[] where = new int[idx];
      int[] pos = new int[idx];
      int chainIdx = 0;
      while (queue.size() > 0) {
        List<Range> chain = new ArrayList<>();
        int p = 0;
        Range top = queue.poll();
        while (top != null) {
          chain.add(top);
          where[top.getIndex()] = chainIdx;
          pos[top.getIndex()] = p++;
          top = nxt[top.getIndex()];
        }
        chains.add(chain);
        chainIdx++;
      }
      while (q-- > 0) {
        int start = in.ni(), vertex = in.ni() - 1, end = in.ni();
        List<Interval> horizontal = intervalsByCity.get(vertex);
        int left = 0, right = horizontal.size() - 1;
        Interval interval = null;
        while (left <= right) {
          int at = (left + right) / 2;
          Interval mid = horizontal.get(at);
          if (mid.start <= start && start <= mid.end) {
            interval = mid;
            break;
          } else if (mid.start > start) {
            right = at - 1;
          } else {
            left = at + 1;
          }
        }
        List<Range> chain = chains.get(where[interval.getIndex()]);
        left = pos[interval.getIndex()];
        right = chain.size() - 1;
        int result = right;
        while (left <= right) {
          int at = (left + right) / 2;
          Range mid = chain.get(at);
          if (mid.getStart() <= end && end <= mid.getEnd()) {
            result = Math.min(result, at);
            right = at - 1;
          } else if (mid.getStart() > end) {
            right = at - 1;
          } else {
            left = at + 1;
          }
        }
        out.println(chain.get(result).getLocation());
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
    try (GreedyTakahashi instance = new GreedyTakahashi()) {
      instance.solve();
    }
  }
}
