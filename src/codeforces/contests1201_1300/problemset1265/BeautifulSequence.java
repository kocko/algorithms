package codeforces.contests1201_1300.problemset1265;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class BeautifulSequence implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    x = new int[4];
    for (int i = 0; i < 4; i++) {
      x[i] = in.ni();
      n += x[i];
    }
    int[] order = {0, 1, 2, 3};
    do {
      int[] attempt = solve(order);
      if (attempt != null) {
        print(attempt);
        return;
      }
    } while (nextPermutation(order));
    out.println("NO");
  }

  private int n;
  private int[] x;

  private int[] solve(int[] order) {
    int[] cnt = {x[order[0]], x[order[1]], x[order[2]], x[order[3]]};
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      result.add(new ArrayList<>());
    }
    result.set(1, extract(order[0], order[1], 0, 1, cnt));
    result.set(3, extract(order[2], order[3], 2, 3, cnt));
    result.set(2, extract(order[2], order[1], 2, 1, cnt));
    if (cnt[1] > 0) {
      result.get(0).add(order[1]);
      cnt[1]--;
    }
    if (cnt[2] > 0) {
      result.get(4).add(order[2]);
      cnt[2]--;
    }
    int[] flat = flat(result);
    return valid(flat) ? flat : null;
  }

  private List<Integer> extract(int a, int b, int idx_a, int idx_b, int[] cnt) {
    List<Integer> result = new ArrayList<>();
    int limit = Math.min(cnt[idx_a], cnt[idx_b]);
    for (int i = 0; i < limit; i++) {
      result.add(a);
      result.add(b);
    }
    cnt[idx_a] -= limit;
    cnt[idx_b] -= limit;
    return result;
  }

  private int[] flat(List<List<Integer>> list) {
    int[] result = new int[n];
    int idx = 0;
    for (List<Integer> lst : list) {
      for (int value : lst) {
        result[idx++] = value;
      }
    }
    return result;
  }

  private boolean valid(int[] p) {
    boolean ok = true;
    int[] count = new int[4];
    count[p[0]]++;
    for (int i = 1; i < n; i++) {
      ok &= abs(p[i] - p[i - 1]) == 1;
      count[p[i]]++;
    }
    for (int i = 0; i < 4; i++) {
      ok &= count[i] == x[i];
    }
    return ok;
  }

  private void print(int[] x) {
    out.println("YES");
    for (int i = 0; i < n; i++) {
      out.print(x[i]);
      out.print(' ');
    }
    out.println();
  }

  private boolean nextPermutation(int[] input) {
    int n = input.length;
    int p = -1;
    for (int i = n - 2; i >= 0; i--) {
      if (input[i] < input[i + 1]) {
        p = i;
        break;
      }
    }
    if (p == -1) return false;

    int q = 0;
    for (int i = n - 1; i > p; i--) {
      if (input[i] > input[p]) {
        q = i;
        break;
      }
    }
    int temp = input[p];
    input[p] = input[q];
    input[q] = temp;
    if (p < n - 1) {
      int left = p + 1, right = n - 1;
      while (left < right) {
        temp = input[left];
        input[left] = input[right];
        input[right] = temp;
        left++;
        right--;
      }
    }
    return true;
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
    try (BeautifulSequence instance = new BeautifulSequence()) {
      instance.solve();
    }
  }
}
