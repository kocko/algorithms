package uva.volume100;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TellMeTheFrequencies implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    boolean hasIncompleteOutput = false;
    while (in.hasNextLine()) {
      if (hasIncompleteOutput) {
        out.println();
      }
      char[] x = in.nextLine().toCharArray();
      Map<Character, Integer> count = new HashMap<>();
      for (char c : x) {
        count.put(c, count.getOrDefault(c, 0) + 1);
      }
      List<int[]> result = new ArrayList<>();
      for (Map.Entry<Character, Integer> entry : count.entrySet()) {
        result.add(new int[]{entry.getValue(), entry.getKey()});
      }
      result.sort(Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> -a[1]));
      for (int[] entry : result) {
        out.println(entry[1] + " " + entry[0]);
      }
      hasIncompleteOutput = true;
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
    try (TellMeTheFrequencies instance = new TellMeTheFrequencies()) {
      instance.solve();
    }
  }
}
