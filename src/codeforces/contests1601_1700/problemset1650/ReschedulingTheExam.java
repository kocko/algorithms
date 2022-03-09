package codeforces.contests1601_1700.problemset1650;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

import static java.lang.Math.max;

public class ReschedulingTheExam implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public ReschedulingTheExam() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), d = in.ni();
      List<Integer> gaps = new ArrayList<>();
      count = new TreeMap<>();
      int last = 0;
      for (int i = 0; i < n; i++) {
        int next = in.ni();
        int gap = next - last - 1;
        gaps.add(gap);
        add(gap);
        last = next;
      }
      int lastGap = d - last;
      int result = count.firstKey();
      for (int idx = 0; idx < gaps.size() - 1; idx++) {
        int left = gaps.get(idx), right = gaps.get(idx + 1);
        remove(left);
        remove(right);
        add(left + right + 1);
        int max = count.lastKey();
        int a;
        if (max % 2 == 0) {
          a = max / 2 - 1;
        } else {
          a = max / 2;
        }

        add(max(a, lastGap - 1));
        result = max(result, count.firstKey());
        remove(max(a, lastGap - 1));

        remove(left + right + 1);
        add(left);
        add(right);
      }
      last = gaps.get(gaps.size() - 1);
      remove(last);
      lastGap += last;
      add(lastGap);
      result = max(result, count.firstKey());
      out.println(result);
    }
  }

  private TreeMap<Integer, Integer> count;

  private void add(int gap) {
    count.put(gap, count.getOrDefault(gap, 0) + 1);
  }

  private void remove(int gap) {
    int cnt = count.get(gap);
    if (cnt == 1) {
      count.remove(gap);
    } else {
      count.put(gap, cnt - 1);
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
    try (ReschedulingTheExam instance = new ReschedulingTheExam()) {
      instance.solve();
    }
  }
}
