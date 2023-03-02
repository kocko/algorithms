package codeforces.contests1701_1800.problemset1800;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class PoweringTheHero implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public PoweringTheHero() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      long result = 0;
      long[] x = new long[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.nl();
      }
      PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());
      for (int i = 0; i < n; i++) {
        if (x[i] > 0) {
          queue.add(x[i]);
        } else {
          if (queue.size() > 0) {
            result += queue.poll();
          }
        }
      }
      out.println(result);
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
    try (PoweringTheHero instance = new PoweringTheHero()) {
      instance.solve();
    }
  }
}
