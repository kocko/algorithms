package codeforces.contests1101_1200.problemset1144;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TwoShuffledSequences implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      queue.offer(in.ni());  
    }
    int last = -1;
    List<Integer> first = new ArrayList<>();
    List<Integer> second = new ArrayList<>();
    while (queue.size() > 0) {
      int top = queue.poll();
      if (top > last) {
        first.add(top);
        last = top;
      } else {
        second.add(top);
      }
    }
    second.sort(Comparator.reverseOrder());
    boolean possible = true;
    for (int i = 1; i < second.size(); i++) {
      possible &= !second.get(i).equals(second.get(i - 1));
    }
    if (!possible) {
      out.println("NO");
    } else {
      out.println("YES");
      print(first);
      print(second);
    }
  }
  
  private void print(List<? extends Integer> list) {
    out.println(list.size());
    for (int value : list) {
      out.print(value);
      out.print(' ');
    }
    out.println();
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
    try (TwoShuffledSequences instance = new TwoShuffledSequences()) {
      instance.solve();
    }
  }
}
