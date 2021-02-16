package codeforces.contests1401_1500.problemset1490;

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

public class AccidentalVictory implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      List<Participant> list = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        int tokens = in.ni();
        list.add(new Participant(i, tokens));
      }
      list.sort(Comparator.comparingLong(Participant::getTokens));
      List<Integer> winners = new ArrayList<>();
      int idx = 0;
      long prefix = 0;
      while (idx < n) {
        List<Participant> same = new ArrayList<>();
        long tokens = list.get(idx).tokens;
        same.add(list.get(idx));
        idx++;
        long score = tokens + prefix;
        while (idx < n && list.get(idx).tokens <= score) {
          same.add(list.get(idx));
          score += list.get(idx).tokens;
          idx++;
        }
        if (score >= list.get(n - 1).tokens) {
          for (Participant p : same) {
            winners.add(p.idx);
          }
        }
        prefix = score;
      }
      winners.sort(Comparator.naturalOrder());
      out.println(winners.size());
      for (int winner : winners) {
        out.print(winner + 1);
        out.print(' ');
      }
      out.println();
    }
  }

  private class Participant {
    private int idx;
    private long tokens;

    private Participant(int idx, long tokens) {
      this.idx = idx;
      this.tokens = tokens;
    }

    private long getTokens() {
      return tokens;
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
    try (AccidentalVictory instance = new AccidentalVictory()) {
      instance.solve();
    }
  }
}
