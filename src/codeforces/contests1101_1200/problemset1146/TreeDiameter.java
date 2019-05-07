package codeforces.contests1101_1200.problemset1146;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeDiameter implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      go(in.ni());
    }
  }
  
  private void go(int n) {
    List<Integer> first = new ArrayList<>(), second = new ArrayList<>();
    first.add(1);
    for (int i = 2; i <= n; i++) {
      second.add(i);
    }
    int d1 = ask(first, second);
    while (second.size() > 1) {
      int mid = second.size() / 2;
      List<Integer> a = new ArrayList<>(), b = new ArrayList<>();
      for (int i = 0; i < mid; i++) {
        a.add(second.get(i));
      }
      for (int i = mid; i < second.size(); i++) {
        b.add(second.get(i));
      }
      int ans = ask(first, a);
      if (ans < d1) {
        second = b;
      } else {
        second = a;
      }
    }
    List<Integer> remaining = new ArrayList<>();
    int farthest = second.get(0);
    for (int i = 1; i <= n; i++) {
      if (i != farthest) {
        remaining.add(i);
      }
    }
    int d2 = ask(second, remaining);
    answer(d1, d2);
  }

  private int ask(List<Integer> first, List<Integer> second) {
    out.print(first.size());
    out.print(' ');
    out.print(second.size());
    out.print(' ');
    for (Integer node : first) {
      out.print(node);
      out.print(' ');
    }
    for (Integer node : second) {
      out.print(node);
      out.print(' ');
    }
    out.flush();
    return in.ni();
  }
  
  private void answer(int d1, int d2) {
    out.printf("-1 %d\n", Math.max(d1, d2));
    out.flush();
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
    try (TreeDiameter instance = new TreeDiameter()) {
      instance.solve();
    }
  }
}
