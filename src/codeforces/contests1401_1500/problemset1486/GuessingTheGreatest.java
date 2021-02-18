package codeforces.contests1401_1500.problemset1486;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GuessingTheGreatest implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int pivot = ask(0, n - 1);
    int left, right;
    if (pivot > 0 && pivot < n - 1) {
      int leftHalf = ask(0, pivot);
      if (leftHalf == pivot) {
        left = 0;
        right = pivot - 1;
      } else {
        left = pivot + 1;
        right = n - 1;
      }
    } else if (pivot == n - 1) {
      left = 0;
      right = n - 2;
    } else {
      left = 1;
      right = n - 1;
    }
    int max;
    if (pivot < left) {
      max = n + 5;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        int response = ask(pivot, mid);
        if (response == pivot) {
          max = Math.min(max, mid);
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
    } else {
      max = -1;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        int response = ask(mid, pivot);
        if (response == pivot) {
          max = Math.max(mid, max);
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    answer(max);
  }

  private int ask(int left, int right) {
    out.printf("? %d %d\n", left + 1, right + 1);
    out.flush();
    return in.ni() - 1;
  }

  private void answer(int idx) {
    out.printf("! %d\n", idx + 1);
    out.flush();
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
    try (GuessingTheGreatest instance = new GuessingTheGreatest()) {
      instance.solve();
    }
  }
}
