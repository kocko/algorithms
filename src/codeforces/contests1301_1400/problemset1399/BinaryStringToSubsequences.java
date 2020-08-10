package codeforces.contests1301_1400.problemset1399;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BinaryStringToSubsequences implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      char[] x = in.next().toCharArray();
      TreeSet<Integer> zeroes = new TreeSet<>(), ones = new TreeSet<>();
      for (int i = 0; i < n; i++) {
        if (x[i] == '0') {
          zeroes.add(i);
        } else {
          ones.add(i);
        }
      }
      int[] result = new int[n];
      int idx = 0;
      while (zeroes.size() > 0 || ones.size() > 0) {
        idx++;
        int nextZero = zeroes.size() > 0 ? zeroes.first() : Integer.MAX_VALUE;
        int nextOne = ones.size() > 0 ? ones.first() : Integer.MAX_VALUE;
        int last, need;
        if (nextZero < nextOne) {
          zeroes.pollFirst();
          last = nextZero;
          need = 1;
        } else {
          ones.pollFirst();
          last = nextOne;
          need = 0;
        }
        result[last] = idx;
        while (true) {
          if (need == 0) {
            Integer nextSuitable = zeroes.ceiling(last);
            if (nextSuitable != null) {
              zeroes.remove(nextSuitable);
              last = nextSuitable;
              need = 1;
              result[nextSuitable] = idx;
            } else break;
          } else {
            Integer nextSuitable = ones.ceiling(last);
            if (nextSuitable != null) {
              ones.remove(nextSuitable);
              last = nextSuitable;
              need = 0;
              result[nextSuitable] = idx;
            } else break;
          }
        }
      }
      out.println(idx);
      for (int i = 0; i < n; i++) {
        out.print(result[i]);
        out.print(' ');
      }
      out.println();
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
    try (BinaryStringToSubsequences instance = new BinaryStringToSubsequences()) {
      instance.solve();
    }
  }
}
