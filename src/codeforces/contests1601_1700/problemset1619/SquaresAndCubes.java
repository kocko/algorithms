package codeforces.contests1601_1700.problemset1619;

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

public class SquaresAndCubes implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public SquaresAndCubes() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public SquaresAndCubes(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int t = in.ni();
    List<Long> x = findSquaresAndCubes();
    while (t-- > 0) {
      long next = in.nl();
      int count = 0;
      for (int i = 0; i < x.size(); i++) if (x.get(i) <= next) count++;
      out.println(count);
    }
  }

  private List<Long> findSquaresAndCubes() {
    final long MAX = (long) 1e9;
    long N = (long) 1e5;
    Set<Long> result = new TreeSet<>();
    for (long i = 1L; i < N; i++) {
      if (i * i <= MAX) {
        result.add(i * i);
      }
    }
    N = (long) 1e3;
    for (long i = 1L; i <= N; i++) {
      if (i * i * i <= MAX) {
        result.add(i * i * i);
      }
    }
    return new ArrayList<>(result);
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
    try (SquaresAndCubes instance = new SquaresAndCubes()) {
      instance.solve();
    }
  }
}
