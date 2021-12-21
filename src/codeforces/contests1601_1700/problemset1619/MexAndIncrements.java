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

import static java.lang.Math.*;

public class MexAndIncrements implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public MexAndIncrements() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[] x = new int[n];
      ArrayDeque<Long> bag = new ArrayDeque<>();
      Map<Integer, Integer> count = new HashMap<>();
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
        count.put(x[i], count.getOrDefault(x[i], 0) + 1);
      }
      Arrays.sort(x);
      long gapCost = 0;
      long[] result = new long[n + 1];
      for (int mex = 0; mex <= n; mex++) {
        if ((mex > 0 && result[mex - 1] == -1) || gapCost == -1) {
          result[mex] = -1;
          continue;
        }
        result[mex] = gapCost;
        int cnt = count.getOrDefault(mex, 0);
        if (cnt == 0) {
          result[mex] = gapCost;
          if (bag.size() > 0) {
            gapCost += (mex - bag.pollLast());
          } else {
            gapCost = -1;
          }
        } else {
          result[mex] += cnt;
          for (int i = 0; i < cnt - 1; i++) {
            bag.add((long) mex);
          }
        }
      }
      for (int i = 0; i <= n; i++) {
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
    try (MexAndIncrements instance = new MexAndIncrements()) {
      instance.solve();
    }
  }
}
