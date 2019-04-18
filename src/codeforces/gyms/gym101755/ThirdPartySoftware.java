package codeforces.gyms.gym101755;

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

public class ThirdPartySoftware implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);
  
  private class Version implements Comparable<Version> {
    private int left, right;

    private Version(int left, int right) {
      this.left = left;
      this.right = right;
    }

    @Override
    public int compareTo(Version o) {
      int x = Integer.compare(right, o.right);
      return x != 0 ? x : Integer.compare(left, o.left);
    }
  }

  public void solve() {
    int n = in.ni();
    List<Version> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(new Version(in.ni(), in.ni()));
    }
    list.sort(Comparator.naturalOrder());
    List<Integer> ends = new ArrayList<>();
    int last = list.get(0).right;
    ends.add(last);
    for (int i = 1; i < n; i++) {
      if (list.get(i).left > last) {
        int en = list.get(i).right;
        ends.add(en);
        last = en;
      }
    }
    out.println(ends.size());
    for (int v : ends) {
      out.print(v);
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
    try (ThirdPartySoftware instance = new ThirdPartySoftware()) {
      instance.solve();
    }
  }
}
