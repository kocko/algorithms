package atcoder.regular.contest142;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeQueries implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public TreeQueries() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int n = in.ni();
    int[] d1 = new int[n + 1];
    int[] d2 = new int[n + 1];
    for (int v = 3; v <= n; v++) {
      d1[v] = ask(1, v);
      d2[v] = ask(2, v);
    }
    int result;
    int min = n + 2;
    List<Integer> list = new ArrayList<>();
    for (int i = 3; i <= n; i++) {
      int d = d1[i] + d2[i];
      if (d < min) {
        min = d;
        list = new ArrayList<>();
        list.add(i);
      } else if (d == min) {
        list.add(i);
      }
    }
    if (min == 3) {
      if (list.size() != 2) {
        result = 1;
      } else {
        int d = ask(list.get(0), list.get(1));
        if (d == 1) {
          result = 3;
        } else {
          result = 1;
        }
      }
    } else {
      result = min;
    }
    answer(result);
  }

  private int ask(int u, int v) {
    out.printf("? %d %d\n", u, v);
    out.flush();
    return in.ni();
  }

  private void answer(int result) {
    out.printf("! %d\n", result);
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
    try (TreeQueries instance = new TreeQueries()) {
      instance.solve();
    }
  }
}
