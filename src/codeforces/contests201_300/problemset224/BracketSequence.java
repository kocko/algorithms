package codeforces.contests201_300.problemset224;

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

public class BracketSequence implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[] x = in.next().toCharArray();
    int n = x.length;
    ArrayDeque<Entry> stack = new ArrayDeque<>();
    int[] match = new int[n];
    for (int i = 0; i < n; i++) {
      match[i] = -1;
    }
    for (int idx = 0; idx < n; idx++) {
      char value = x[idx];
      if (value == '(' || value == '[') {
        stack.offerLast(new Entry(idx, value));
      } else {
        if (!stack.isEmpty()) {
          Entry last = stack.peekLast();
          if (match(last.value, value)) {
            Entry opening = stack.pollLast();
            match[opening.idx] = idx;
          } else {
            stack.clear();
          }
        }
      }
    }
    int[] prefix = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      prefix[i] = prefix[i - 1];
      if (x[i - 1] == '[') {
        prefix[i]++;
      }
    }
    ArrayDeque<int[]> seq = new ArrayDeque<>();
    int lastEnd = -1;
    for (int idx = 0; idx < n; idx++) {
      if (match[idx] > 0 && match[idx] > lastEnd) {
        seq.addLast(new int[]{idx, match[idx]});
        lastEnd = match[idx];
      }
    }
    if (seq.size() > 0) {
      int[] current = seq.pollFirst();
      int start = current[0], end = current[1];
      List<int[]> merged = new ArrayList<>();
      while (seq.size() > 0) {
        int[] next = seq.pollFirst();
        if (next[0] == end + 1) {
          end = next[1];
        } else {
          merged.add(new int[]{start, end});
          start = next[0];
          end = next[1];
        }
      }
      merged.add(new int[]{start, end});
      int brackets = 0;
      int[] best = {0, 0};
      for (int[] interval : merged) {
        int count = prefix[interval[1]] - prefix[interval[0]];
        if (count > brackets) {
          brackets = count;
          best = interval;
        }
      }
      out.println(brackets);
      if (brackets > 0) {
        for (int idx = best[0]; idx <= best[1]; idx++) {
          out.print(x[idx]);
        }
      }
    } else {
      out.println(0);
    }
  }

  private boolean match(char a, char b) {
    return (a == '(' && b == ')') || (a == '[' && b == ']');
  }

  private class Entry {
    private int idx;
    private char value;

    private Entry(int idx, char value) {
      this.idx = idx;
      this.value = value;
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
    try (BracketSequence instance = new BracketSequence()) {
      instance.solve();
    }
  }
}
