package atcoder.beginner.contest224;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class IntegersOnGrid implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public IntegersOnGrid() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int H = in.ni(), W = in.ni(), N =  in.ni();
    List<Num> list = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      int r = in.ni(), c = in.ni(), v = in.ni();
      list.add(new Num(i, r, c, v));
    }
    list.sort(Comparator.comparingInt(Num::getValue).reversed());
    int[] maxOnRow = new int[H + 1];
    int[] maxOnCol = new int[W + 1];
    ArrayDeque<int[]> delta = new ArrayDeque<>();
    int idx = 0;
    Num first;
    while (idx < N && (first = list.get(idx)).value == list.get(0).value) {
      maxOnRow[first.row] = maxOnCol[first.col] = first.result = 1;
      idx++;
    }
    while (idx < N) {
      Num now = list.get(idx), prev = list.get(idx - 1);
      if (now.value < prev.value) {
        while (delta.size() > 0) {
          int[] entry = delta.pollFirst();
          int r = entry[0], c = entry[1], score = entry[2];
          maxOnRow[r] = Math.max(maxOnRow[r], score);
          maxOnCol[c] = Math.max(maxOnCol[c], score);
        }
      }
      now.result = Math.max(maxOnRow[now.row], maxOnCol[now.col]) + 1;
      delta.add(new int[]{now.row, now.col, now.result});
      idx++;
    }
    list.sort(Comparator.comparingInt(Num::getIdx));
    list.stream().map(num -> num.result - 1).forEach(out::println);
  }

  private class Num {
    private int idx, row, col, value, result;

    private Num(int idx, int row, int col, int value) {
      this.idx = idx;
      this.row = row;
      this.col = col;
      this.value = value;
    }

    public int getValue() {
      return value;
    }

    public int getIdx() {
      return idx;
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
    try (IntegersOnGrid instance = new IntegersOnGrid()) {
      instance.solve();
    }
  }

}
