package codeforces.contests1101_1200.problemset1185;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ExamInBerSU implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), M = in.ni();
    int[] x = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
    }
    int[] count = new int[101];
    int[] result = new int[n];
    int totalTime = 0;
    for (int i = 0; i < n; i++) {
      if (totalTime + x[i] <= M) {
        result[i] = 0;
      } else {
        int target = totalTime + x[i] - M, fail = 0, current = 0;
        for (int time = 100; time >= 1 && current < target; time--) {
          if (current + time * count[time] <= target) {
            current += time * count[time];
            fail += count[time];
          } else {
            int diff = target - current;
            int students = diff / time + (diff % time != 0 ? 1 : 0);
            fail += students;
            current += students * time;
          }
        }
        result[i] = fail;
      }
      count[x[i]]++;
      totalTime += x[i];
    }
    for (int i = 0; i < n; i++) {
      out.print(result[i]);
      out.print(' ');
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
    try (ExamInBerSU instance = new ExamInBerSU()) {
      instance.solve();
    }
  }
}
