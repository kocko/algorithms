package codeforces.contests1101_1200.problemset1138;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Circus implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    char[] c = in.next().toCharArray();
    char[] a = in.next().toCharArray();
    List<Integer> clowns = new ArrayList<>(), acrobats = new ArrayList<>(), both = new ArrayList<>(), none = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (c[i] == '1') {
        if (a[i] == '1') {
          both.add(i + 1);
        } else {
          clowns.add(i + 1);
        }
      } else {
        if (a[i] == '1') {
          acrobats.add(i + 1);
        } else {
          none.add(i + 1);
        }
      }
    }
    int half = n / 2;
    int max = clowns.size() >= half ? half : clowns.size();
    for (int target = 0; target <= max; target++) {
      List<Integer> first = new ArrayList<>();
      int clownsHere = target;
      int acrobatsHere = both.size() + acrobats.size() - target;
      for (int i = 0; i < both.size() && first.size() < half && first.size() < target; i++) {
        first.add(both.get(i));
      }
      acrobatsHere -= first.size();
      clownsHere -= first.size();
      for (int i = 0; i < acrobats.size() && acrobatsHere > 0; i++) {
        first.add(acrobats.get(i));
        acrobatsHere--;
      }
      if (acrobatsHere == 0) {
        if (clownsHere > 0) {
          for (int i = 0; i < clowns.size() && clownsHere > 0; i++) {
            first.add(clowns.get(i));
            clownsHere--;
          }
        }
        if (clownsHere == 0) {
          int idx = 0;
          while (first.size() < half && idx < none.size()) {
            first.add(none.get(idx++));
          }
          if (first.size() == half) {
            for (int artist : first) {
              out.print(artist);
              out.print(' ');
            }
            return;
          }
        }
      }
    }
    out.println(-1);
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
    try (Circus instance = new Circus()) {
      instance.solve();
    }
  }
}
