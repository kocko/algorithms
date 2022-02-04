package atcoder.beginner.contest126;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class XorMatching implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public XorMatching() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int m = in.ni(), k = in.ni();
    if (m == 0) {
      if (k == 0) {
        out.println("0 0");
      } else {
        out.println("-1");
      }
      return;
    }
    if (m == 1) {
      if (k == 0) {
        out.println("0 0 1 1");
      } else {
        out.println("-1");
      }
      return;
    }
    if (k >= (1 << m)) {
      out.println("-1");
    } else {
      ArrayDeque<Integer> queue = new ArrayDeque<>();
      queue.add(k);
      for (int i = 0; i < 1 << m; i++) {
        if (i != k) {
          queue.addFirst(i);
          queue.addLast(i);
        }
      }
      queue.add(k);
      while (queue.size() > 0) {
        out.print(queue.pollFirst());
        out.print(' ');
      }
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
    try (XorMatching instance = new XorMatching()) {
      instance.solve();
    }
  }
}
