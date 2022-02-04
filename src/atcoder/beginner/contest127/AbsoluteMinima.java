package atcoder.beginner.contest127;

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

public class AbsoluteMinima implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public AbsoluteMinima() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int q = in.ni();
    PriorityQueue<Long> left = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Long> right = new PriorityQueue<>();
    long leftSum = 0, rightSum = 0, constant = 0;
    while (q-- > 0) {
      int type = in.ni();
      if (type == 1) {
        long a = in.nl(), b = in.nl();
        left.add(a);
        leftSum += a;
        while (left.size() - 2 == right.size()) {
          long top = left.poll();
          leftSum -= top;
          right.add(top);
          rightSum += top;
        }
        while (left.size() > 0 && right.size() > 0 && left.peek() > right.peek()) {
          long move = left.poll();
          right.add(move);
          leftSum -= move;
          rightSum += move;

          move = right.poll();
          left.add(move);
          leftSum += move;
          rightSum -= move;
        }
        constant += b;
      } else {
        long median = left.peek();
        long result = median * left.size() - leftSum + rightSum - median * right.size() + constant;
        out.println(median + " " + result);
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
    try (AbsoluteMinima instance = new AbsoluteMinima()) {
      instance.solve();
    }
  }
}
