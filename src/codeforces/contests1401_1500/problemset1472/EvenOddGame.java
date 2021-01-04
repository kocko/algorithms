package codeforces.contests1401_1500.problemset1472;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class EvenOddGame implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      long[] x = new long[n];
      PriorityQueue<Long> even = new PriorityQueue<>(Comparator.reverseOrder()), odd = new PriorityQueue<>(Comparator.reverseOrder());
      for (int i = 0; i < n; i++) {
        x[i] = in.nl();
        if (x[i] % 2 == 0) {
          even.add(x[i]);
        } else {
          odd.add(x[i]);
        }
      }
      boolean alice = true;
      long a = 0, b = 0;
      while (even.size() > 0 || odd.size() > 0) {
        if (alice) {
          long ev = even.size() > 0 ? even.peek() : 0;
          long od = odd.size() > 0 ? odd.peek() : 0;
          if (ev > od) {
            a += ev;
            even.poll();
          } else {
            odd.poll();
          }
        } else {
          long ev = even.size() > 0 ? even.peek() : 0;
          long od = odd.size() > 0 ? odd.peek() : 0;
          if (od > ev) {
            b += od;
            odd.poll();
          } else {
            even.poll();
          }
        }
        alice = !alice;
      }
      out.println(a == b ? "Tie" : (a > b ? "Alice" : "Bob"));
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
    try (EvenOddGame instance = new EvenOddGame()) {
      instance.solve();
    }
  }
}
