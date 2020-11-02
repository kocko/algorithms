package codeforces.contests1401_1500.problemset1443;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SavingTheCity implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      long a = in.nl(), b = in.nl();
      char[] x = in.next().toCharArray();
      List<Integer> one = new ArrayList<>();
      List<Integer> zero = new ArrayList<>();
      int n = x.length;
      int start = n;
      for (int i = 0; i < n; i++) {
        if (x[i] == '1') {
          start = i;
          break;
        }
      }
      char current = '1';
      int size = 0;
      for (int i = start; i < n; i++) {
        if (x[i] == current) {
          size++;
        } else {
          if (current == '1') {
            one.add(size);
            current = '0';
          } else {
            zero.add(size);
            current = '1';
          }
          size = 1;
        }
      }
      if (current == '1' && size > 0) {
        one.add(size);
      }
      long result = 0;
      if (one.size() > 0) {
        int[] p = new int[one.size() + zero.size()];
        for (int idx = 0, i = 0; i < zero.size(); i++, idx += 2) {
          p[idx] = one.get(i);
          p[idx + 1] = zero.get(i);
        }
        p[p.length - 1] = one.get(one.size() - 1);
        int idx = 0;
        long currentCost = 0;
        while (idx + 1 < p.length) {
          if (p[idx + 1] * b <= a) {
            currentCost += b * p[idx + 1];
          } else {
            result += currentCost + a;
            currentCost = 0;
          }
          idx += 2;
        }
        result += currentCost + a;
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
    try (SavingTheCity instance = new SavingTheCity()) {
      instance.solve();
    }
  }
}
