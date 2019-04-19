package codeforces.gyms.gym101755;

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
import java.util.TreeSet;

public class QueriesOnAString implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[] x = in.next().toCharArray();
    int n = x.length;
    List<TreeSet<Integer>> sets = new ArrayList<>();
    for (int i = 0; i < 26; i++) {
      sets.add(new TreeSet<>());
    }
    for (int i = 0; i < n; i++) {
      int idx = x[i] - 'a';
      sets.get(idx).add(i);
    }
    ArrayDeque<Boolean> answers = new ArrayDeque<>();
    ArrayDeque<Integer> ends = new ArrayDeque<>();
    
    int operations = in.ni(), start = -1;
    while (operations-- > 0) {
      String type = in.next();
      boolean response;
      if ("push".equals(type)) {
        char letter = in.next().charAt(0);
        TreeSet<Integer> set = sets.get(letter - 'a');
        Integer next = set.higher(start);
        if (next != null) {
          start = next; 
        } else {
          start = n;
        }
        ends.add(start);
        answers.add(response = start < n);
      } else {
        ends.pollLast();
        answers.pollLast();
        if (answers.size() > 0) {
          response = answers.peekLast();
          start = ends.peekLast();
        } else {
          response = true;
          start = -1;
        }
      }
      out.println(response ? "YES" : "NO");
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
    try (QueriesOnAString instance = new QueriesOnAString()) {
      instance.solve();
    }
  }
}
