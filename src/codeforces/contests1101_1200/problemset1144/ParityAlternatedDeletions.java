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
import java.util.StringTokenizer;

public class ParityAlternatedDeletions implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), sum = 0;
    List<Integer> even = new ArrayList<>(), odd = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int next = in.ni();
      if (next % 2 == 0) {
        even.add(next);
      } else {
        odd.add(next);
      }
      sum += next;
    }
    even.sort(Comparator.reverseOrder());
    odd.sort(Comparator.reverseOrder());
    int moves = Math.min(even.size(), odd.size());
    for (int i = 0; i < moves; i++) {
      sum -= even.get(i);
      sum -= odd.get(i);
    }
    if (moves < even.size()) {
      sum -= even.get(moves);
    }
    if (moves < odd.size()) {
      sum -= odd.get(moves);
    }
    out.println(sum);
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
    try (ParityAlternatedDeletions instance = new ParityAlternatedDeletions()) {
      instance.solve();
    }
  }
}
