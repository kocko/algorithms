package codeforces.contests1701_1800.problemset1714;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BuildATreeAndThatIsIt implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public BuildATreeAndThatIsIt() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int[] label = new int[4];
      for (int i = 1; i <= 3; i++) {
        label[i] = i;
      }
      int n = in.ni(), d12 = in.ni(), d23 = in.ni(), d13 = in.ni();
      int[] tmp = {d12, d23, d13};
      Arrays.sort(tmp);
      if (tmp[0] + tmp[1] < tmp[2]) {
        out.println("NO");
        continue;
      }
      List<int[]> result;
      if (d13 >= d12 && d13 >= d23) {
        label[2] = 3;
        label[3] = 2;
        result = buildTree(n, d13, d12, d23);
      } else if (d23 >= d12 && d23 >= d13) {
        label[1] = 3;
        label[3] = 1;
        result = buildTree(n, d23, d13, d12);
      } else {
        result = buildTree(n, d12, d13, d23);
      }
      if (result.size() == 0) {
        out.println("NO");
      } else {
        out.println("YES");
        for (int[] edge : result) {
          int u = edge[0] > 3 ? edge[0] : label[edge[0]];
          int v = edge[1] > 3 ? edge[1] : label[edge[1]];
          out.println(u + " " + v);
        }
      }
    }
  }

  private List<int[]> buildTree(int n, int a, int b, int c) {
    List<int[]> result = new ArrayList<>();
    ArrayDeque<Integer> nextVertex = new ArrayDeque<>();
    for (int i = 4; i <= n; i++) {
      nextVertex.add(i);
    }
    if (a == b + c) {
      int u = 1;
      int x = 0, len = a;
      while (len-- > 1) {
        x++;
        int y = a - x;
        int[] edge;
        if (x == b && y == c) {
          edge = new int[]{u, 3};
        } else {
          if (nextVertex.size() == 0) return Collections.emptyList();
          edge = new int[]{u, nextVertex.pollFirst()};
        }
        result.add(edge);
        u = edge[1];
      }
      result.add(new int[]{u, 2});
    } else {
      int len = a;
      int u = 1;
      while (len-- > 1) {
        if (nextVertex.size() == 0) return Collections.emptyList();
        int[] edge = {u, nextVertex.pollFirst()};
        result.add(edge);
        u = edge[1];
      }
      result.add(new int[]{u, 2});
      int x = 0;
      u = -1;
      for (int[] edge : result) {
        x++;
        int y = a - x;
        int z = b - x;
        if (y + z == c) {
          u = edge[1];
          break;
        }
      }
      if (u == -1) {
        return Collections.emptyList();
      }
      int z = b - x;
      while (z-- > 1) {
        if (nextVertex.size() == 0) return Collections.emptyList();
        int[] next = new int[]{u, nextVertex.pollFirst()};
        result.add(next);
        u = next[1];
      }
      result.add(new int[]{u, 3});
    }
    while (result.size() < n - 1) {
      if (nextVertex.size() == 0) return Collections.emptyList();
      result.add(new int[]{1, nextVertex.pollFirst()});
    }
    return result;
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
    try (BuildATreeAndThatIsIt instance = new BuildATreeAndThatIsIt()) {
      instance.solve();
    }
  }
}
