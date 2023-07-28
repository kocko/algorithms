package codeforces.contests1801_1900.problemset1851;

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

public class ParitySort implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public ParitySort() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      int[] x = new int[n];
      List<Integer> even = new ArrayList<>(), odd = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
        if (x[i] % 2 == 0) {
          even.add(x[i]);
        } else {
          odd.add(x[i]);
        }
      }
      even.sort(Comparator.naturalOrder());
      odd.sort(Comparator.naturalOrder());
      int nextEven = 0, nextOdd = 0, last = -1;
      boolean can = true;
      for (int i = 0; i < n; i++) {
        int next;
        if (x[i] % 2 == 0) {
          next = even.get(nextEven++);
        } else {
          next = odd.get(nextOdd++);
        }
        can &= next >= last;
        last = next;
      }
      out.println(can ? "YES" : "NO");
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
    try (ParitySort instance = new ParitySort()) {
      instance.solve();
    }
  }
}
