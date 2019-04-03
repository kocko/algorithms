package codeforces.contests1101_1200.problemset1144;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EqualizeThemAll implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] x = new int[n];
    int[] cnt = new int[200001];
    int best = -1, count = -1;
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
      cnt[x[i]]++;
      if (cnt[x[i]] > count) {
        best = x[i];
        count = cnt[x[i]];
      }
    }
    ArrayDeque<Integer> indices = new ArrayDeque<>();
    for (int i = 0; i < n - 1; i++) {
      if (x[i] != best && x[i + 1] == best) {
        indices.offerLast(i);
      }
    }
    for (int i = n - 1; i >= 1; i--) {
      if (x[i] != best && x[i - 1] == best) {
        indices.offerLast(i);
      }
    }
    List<int[]> operations = new ArrayList<>();
    while (indices.size() > 0) {
      int idx = indices.pollFirst();
      if (x[idx] == best) continue;
      if (idx > 0 && x[idx - 1] == best) {
        if (x[idx] < best) {
          operations.add(new int[]{1, idx + 1, idx});
        } else {
          operations.add(new int[]{2, idx + 1, idx});
        }
      } else if (idx < n - 1 && x[idx + 1] == best) {
        if (x[idx] < best) {
          operations.add(new int[]{1, idx + 1, idx + 2});
        } else {
          operations.add(new int[]{2, idx + 1, idx + 2});
        }
      }
      x[idx] = best;
      if (idx + 1 < n && x[idx + 1] != best) {
        indices.add(idx + 1);
      } else if (idx - 1 >= 0 && x[idx - 1] != best) {
        indices.add(idx - 1);
      }
    }
    out.println(operations.size());
    for (int[] operation : operations) {
      for (int i = 0; i < 3; i++) {
        out.print(operation[i]);
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
    try (EqualizeThemAll instance = new EqualizeThemAll()) {
      instance.solve();
    }
  }
}
