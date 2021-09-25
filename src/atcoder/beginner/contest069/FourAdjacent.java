package atcoder.beginner.contest069;

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

public class FourAdjacent implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public FourAdjacent() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public FourAdjacent(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int n = in.ni();
    ArrayDeque<Integer> four = new ArrayDeque<>(), two = new ArrayDeque<>(), other = new ArrayDeque<>();
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      int next = in.ni();
      if (next % 4 == 0) {
        four.add(next);
      } else if (next % 2 == 0) {
        two.add(next);
      } else {
        other.add(next);
      }
    }
    int idx = 0;
    while (two.size() > 0) {
      result[idx++] = two.poll();
    }
    boolean addFour = idx > 0 || (four.size() > other.size());
    while (idx < n) {
      if (addFour) {
        if (four.size() > 0) {
          result[idx++] = four.poll();
        }
      } else {
        if (other.size() > 0) {
          result[idx++] = other.poll();
        }
      }
      addFour = !addFour;
    }
    boolean ok = true;
    for (int i = 1; i < n; i++) {
      ok &= (result[i] * result[i - 1]) % 4 == 0;
    }
    out.println(ok ? "Yes" : "No");
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
    try (FourAdjacent instance = new FourAdjacent()) {
      instance.solve();
    }
  }
}
