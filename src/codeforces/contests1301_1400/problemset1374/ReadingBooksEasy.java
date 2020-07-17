package codeforces.contests1301_1400.problemset1374;

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

public class ReadingBooksEasy implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), k = in.ni();
    List<Integer> both = new ArrayList<>(), alice = new ArrayList<>(), bob = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int time = in.ni(), a = in.ni(), b = in.ni();
      if (a == 1 && b == 1) {
        both.add(time);
      } else if (a == 1) {
        alice.add(time);
      } else if (b == 1) {
        bob.add(time);
      }
    }
    both.sort(Comparator.naturalOrder());
    alice.sort(Comparator.naturalOrder());
    bob.sort(Comparator.naturalOrder());
    int[] bothPrefix = prefix(both);
    int[] alicePrefix = prefix(alice);
    int[] bobPrefix = prefix(bob);
    final int oo = Integer.MAX_VALUE;
    int result = oo;
    for (int readBoth = 0; readBoth < Math.min(k + 1, bothPrefix.length); readBoth++) {
      int temp = bothPrefix[readBoth];
      int remaining = k - readBoth;
      if (remaining <= alice.size() && remaining <= bob.size()) {
        temp += alicePrefix[remaining];
        temp += bobPrefix[remaining];
        result = Math.min(result, temp);
      }
    }
    out.println(result != oo ? result : -1);
  }

  private int[] prefix(List<Integer> list) {
    int n = list.size();
    int[] result = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      result[i] = result[i - 1] + list.get(i - 1);
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
    try (ReadingBooksEasy instance = new ReadingBooksEasy()) {
      instance.solve();
    }
  }
}
