package google.codejam2020.qualification;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ParentingPartneringReturns implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    for (int testCase = 1; testCase <= T; testCase++) {
      int n = in.ni();
      PriorityQueue<Task> queue = new PriorityQueue<>();
      char[] result = new char[n];
      for (int i = 0; i < n; i++) {
        queue.add(new Task(i, in.ni(), in.ni()));
      }
      boolean possible = true;
      int c = -1, j = -1;
      while (queue.size() > 0) {
        Task next = queue.poll();
        if (c < next.start) {
          c = next.end - 1;
          result[next.idx] = 'C';
        } else if (j < next.start) {
          j = next.end - 1;
          result[next.idx] = 'J';
        } else {
          possible = false;
          break;
        }
      }
      String output = possible ? new String(result) : "IMPOSSIBLE";
      out.printf("Case #%d: %s\n", testCase, output);
    }
  }

  private class Task implements Comparable<Task> {
    private int idx, start, end;

    private Task(int idx, int start, int end) {
      this.idx = idx;
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Task task) {
      return Integer.compare(this.start, task.start);
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
    try (ParentingPartneringReturns instance = new ParentingPartneringReturns()) {
      instance.solve();
    }
  }
}
