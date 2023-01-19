package atcoder.beginner.contest243;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class MovesOnBinaryTree implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public MovesOnBinaryTree() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int n = in.ni();
    long vertex = in.nl();
    char[] moves = in.next().toCharArray();
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      char move = moves[i];
      if (move == 'U') {
        if (stack.size() == 0) {
          vertex >>= 1;
        } else {
          stack.pollLast();
        }
      } else if (move == 'R') {
        stack.addLast(1);
      } else {
        stack.addLast(0);
      }
    }
    while (stack.size() > 0) {
      int bit = stack.pollFirst();
      vertex = (vertex << 1) | bit;
    }
    out.println(vertex);
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
    try (MovesOnBinaryTree instance = new MovesOnBinaryTree()) {
      instance.solve();
    }
  }
}