package codeforces.contests1201_1300.problemset1251;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MinimizeTheInteger implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      char[] x = in.next().toCharArray();
      int n = x.length;
      List<Integer> even = new ArrayList<>(), odd = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        int value = x[i] - '0';
        if (value % 2 == 0) {
          even.add(i);
        } else {
          odd.add(i);
        }
      }
      int idx = 0, i = 0, j = 0;
      while (idx < n) {
        char e = i < even.size() ? x[even.get(i)] : 'A';
        char o = j < odd.size() ? x[odd.get(j)] : 'A';
        if (e < o) {
          out.print(e);
          i++;
        } else {
          out.print(o);
          j++;
        }
        idx++;
      }
      out.println();
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
    try (MinimizeTheInteger instance = new MinimizeTheInteger()) {
      instance.solve();
    }
  }
}
