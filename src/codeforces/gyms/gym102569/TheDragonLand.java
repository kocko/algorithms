package codeforces.gyms.gym102569;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class TheDragonLand implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    PriorityQueue<Long> queue = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      long next = in.nl();
      queue.add(next);
      while (queue.size() > 0) {
        long smallest = queue.peek(), k = queue.size();
        if (smallest <= k) {
          queue.poll();
        } else break;
      }
    }
    long gold = 0, k = 1;
    while (queue.size() > 0) {
      gold += queue.poll();
      gold -= k;
      k++;
    }
    out.println(gold);
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
    try (TheDragonLand instance = new TheDragonLand()) {
      instance.solve();
    }
  }
}
