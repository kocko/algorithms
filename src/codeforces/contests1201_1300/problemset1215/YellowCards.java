package codeforces.contests1201_1300.problemset1215;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class YellowCards implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int a1 = in.ni(), a2 = in.ni(), k1 = in.ni(), k2 = in.ni(), n = in.ni();

    PriorityQueue<Integer> inc = new PriorityQueue<>();
    PriorityQueue<Integer> dec = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < a1; i++) {
      inc.add(k1);
      dec.add(k1);
    }
    for (int i = 0; i < a2; i++) {
      inc.add(k2);
      dec.add(k2);
    }

    int max = 0;
    for (int i = 0; i < n; i++) {
      int top = inc.poll();
      if (top > 1) {
        inc.offer(top - 1);
      } else {
        max++;
      }
    }
    int min = 0;
    for (int i = 0; i < n; i++) {
      int top = dec.poll();
      if (top > 1) {
        dec.offer(top - 1);
      } else {
        min++;
      }
    }
    out.println(min + " " + max);
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
    try (YellowCards instance = new YellowCards()) {
      instance.solve();
    }
  }
}
