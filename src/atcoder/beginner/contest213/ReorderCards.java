package atcoder.beginner.contest213;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class ReorderCards implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public ReorderCards() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    class Card {
      private int idx, row, col, nRow, nCol;

      Card(int idx, int row, int col) {
        this.idx = idx;
        this.row = row;
        this.col = col;
      }

      @Override
      public String toString() {
        return nRow + " " + nCol;
      }
    }
    List<Card> cards = new ArrayList<>();
    int H = in.ni(), W = in.ni(), n = in.ni();
    for (int i = 0; i < n; i++) {
      cards.add(new Card(i, in.ni(), in.ni()));
    }
    cards.sort(Comparator.comparingInt(card -> card.row));
    int idx = 1, prev = -1;
    for (Card card : cards) {
      if (prev == -1) {
        prev = card.row;
        card.nRow = idx;
      } else if (card.row != prev) {
        card.nRow = ++idx;
        prev = card.row;
      } else {
        card.nRow = idx;
      }
    }
    cards.sort(Comparator.comparingInt(card -> card.col));
    idx = 1;
    prev = -1;
    for (Card card : cards) {
      if (prev == -1) {
        prev = card.col;
        card.nCol = idx;
      } else if (card.col != prev) {
        card.nCol = ++idx;
        prev = card.col;
      } else {
        card.nCol = idx;
      }
    }
    cards.sort(Comparator.comparingInt(card -> card.idx));
    cards.forEach(out::println);
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
    try (ReorderCards instance = new ReorderCards()) {
      instance.solve();
    }
  }
}
