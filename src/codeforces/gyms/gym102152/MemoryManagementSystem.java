package codeforces.gyms.gym102152;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Comparator.naturalOrder;

public class MemoryManagementSystem implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni(), q = in.ni();
      List<Interval> list = new ArrayList<>();
      list.add(new Interval(0, 0));
      list.add(new Interval(m + 1, m + 1));
      for (int i = 0; i < n; i++) {
        int left = in.ni(), right = in.ni();
        list.add(new Interval(left, right));
      }
      list.sort(naturalOrder());
      int[] max = new int[m + 1];
      for (int i = 0; i <= m; i++) {
        max[i] = -1;
      }
      for (int i = 1; i < list.size(); i++) {
        Interval prev = list.get(i - 1), current = list.get(i);
        int left = prev.right + 1, right = current.left - 1, size = right - left + 1;
        max[size] = Math.max(max[size], right);
      }
      
      for (int i = m - 1; i >= 1; i--) {
        max[i] = Math.max(max[i], max[i + 1]);
      }
      while (q-- > 0) {
        int size = in.ni(), left = -1, right = -1;
        if (max[size] != -1) {
          left = max[size] - size + 1;
          right = max[size];
        }
        out.println(left + " " + right);
      }
    }
  }
  
  private class Interval implements Comparable<Interval> {
    private int left, right;

    private Interval(int left, int right) {
      this.left = left;
      this.right = right;
    }

    @Override
    public int compareTo(Interval o) {
      return Integer.compare(this.right, o.right);
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
    try (MemoryManagementSystem instance = new MemoryManagementSystem()) {
      instance.solve();
    }
  }
}
