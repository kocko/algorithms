package codeforces.contests1301_1400.problemset1333;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ChallengesInSchool41 implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), k = in.ni();
    char[] x = in.next().toCharArray();
    ArrayDeque<ArrayDeque<Integer>> queue = new ArrayDeque<>();
    int min = 0, max = 0;
    while (true) {
      ArrayDeque<Integer> entry = new ArrayDeque<>();
      for (int i = 0; i < n - 1; ) {
        if (x[i] == 'R' && x[i + 1] == 'L') {
          char t = x[i];
          x[i] = x[i + 1];
          x[i + 1] = t;
          entry.addLast(i + 1);
          max++;
          i += 2;
        } else {
          i++;
        }
      }
      if (entry.size() > 0) {
        queue.add(entry);
      } else break;
    }
    min = queue.size();
    if (k < min || k > max) {
      out.println(-1);
      return;
    }
    List<List<Integer>> result = expandToSize(queue, k);
    for (List<Integer> entry : result) {
      out.print(entry.size());
      out.print(' ');
      for (int value : entry) {
        out.print(value);
        out.print(' ');
      }
      out.println();
    }
  }

  private List<List<Integer>> expandToSize(ArrayDeque<ArrayDeque<Integer>> queue, int k) {
    List<List<Integer>> result = new ArrayList<>();
    if (queue.size() == k) {
      for (ArrayDeque<Integer> deque : queue) {
        result.add(new ArrayList<>(deque));
      }
    } else {
      while (result.size() + queue.size() < k) {
        if (queue.size() == 0) return Collections.emptyList();
        ArrayDeque<Integer> deque = queue.peekFirst();

        int element = deque.pollFirst();

        result.add(Collections.singletonList(element));
        if (deque.size() == 0) {
          queue.pollFirst();
        }
      }
      for (ArrayDeque<Integer> remaining : queue) {
        List<Integer> entry = new ArrayList<>();
        while (remaining.size() > 0) {
          entry.add(remaining.pollFirst());
        }
        result.add(entry);
      }
    }
    return result;
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
    try (ChallengesInSchool41 instance = new ChallengesInSchool41()) {
      instance.solve();
    }
  }
}
