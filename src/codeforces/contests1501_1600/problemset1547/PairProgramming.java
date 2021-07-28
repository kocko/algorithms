package codeforces.contests1501_1600.problemset1547;

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

public class PairProgramming implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public PairProgramming() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public PairProgramming(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int size = in.ni(), N = in.ni(), M = in.ni();
      int[] mono = new int[N];
      int[] poly = new int[M];
      for (int i = 0; i < N; i++) {
        mono[i] = in.ni();
      }
      for (int i = 0; i < M; i++) {
        poly[i] = in.ni();
      }
      List<Integer> result = new ArrayList<>();
      int p = 0, m = 0;
      boolean possible = true;
      while (m < N || p < M) {
        boolean added = false;
        while (m < N && mono[m] == 0) {
          result.add(0);
          size++;
          m++;
          added = true;
        }
        while (p < M && poly[p] == 0) {
          result.add(0);
          size++;
          p++;
          added = true;
        }
        if (m < N && mono[m] <= size) {
          result.add(mono[m]);
          m++;
          added = true;
        }
        if (p < M && poly[p] <= size) {
          result.add(poly[p]);
          p++;
          added = true;
        }
        if (!added) {
          possible = false;
          break;
        }
      }
      if (possible) {
        for (int action : result) {
          out.print(action);
          out.print(' ');
        }
        out.println();
      } else {
        out.println(-1);
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
    try (PairProgramming instance = new PairProgramming()) {
      instance.solve();
    }
  }
}
