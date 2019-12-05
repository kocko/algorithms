package practice.contest;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
    while (nextPermutation(order)) {
      int[] attempt = solve(order);
      if (attempt != null) {
        print(attempt);
        return;
      }
    }
    out.println("NO");
  }

  private int n;
  private int[] x;

  private int[] solve(int[] order) {
    int[] cnt = {x[order[0]], x[order[1]], x[order[2]], x[order[3]]};
    int[] result = new int[n];

    int idx = 0;
    if (cnt[0] > cnt[1]) {
      if (cnt[0] - cnt[1] == 1) {
        result[idx++] = order[0];
        cnt[0]--;
        while (cnt[0] > 0) {
          result[idx] = order[1];
          result[idx + 1] = order[0];
          idx += 2;
          cnt[1]--;
          cnt[0]--;
        }
      } else {
        return null;
      }
    } else if (cnt[0] == cnt[1]) {
      while (cnt[0] > 0) {
        result[idx] = order[0];
        result[idx + 1] = order[1];
        idx += 2;
        cnt[1]--;
        cnt[0]--;
      }
    } else {
      while (cnt[0] > 0) {
        result[idx] = order[1];
        result[idx + 1] = order[0];
        idx += 2;
        cnt[1]--;
        cnt[0]--;
      }
      result[idx++] = order[1];
      cnt[1]--;
    }

    //transition
    if (cnt[2] > 0) {
      result[idx++] = order[2];
      cnt[2]--;
    }

    while (cnt[3] > 0) {
      result[idx] = order[3];
      cnt[3]--;
      idx++;
      if (idx < n && cnt[2] > 0) {
        result[idx] = order[2];
        cnt[2]--;
        idx++;
      } else break;
    }
    if (abs(cnt[1] - cnt[2]) < 1) {
      while (idx < n) {
        if (cnt[1] > 0) {
          result[idx++] = order[1];
          cnt[1]--;
        } else break;
        if (idx < n && cnt[2] > 0) {
          result[idx++] = order[2];
          cnt[2]--;
        } else break;
      }
    } else {
      return null;
    }
    if (cnt[0] == 0 && cnt[1] == 0 && cnt[2] == 0 && cnt[3] == 0) {
      for (int i = 1; i < n; i++) {
        if (abs(result[i] - result[i - 1]) != 1) {
          return null;
        }
      }
      return result;
    }
    return null;
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
