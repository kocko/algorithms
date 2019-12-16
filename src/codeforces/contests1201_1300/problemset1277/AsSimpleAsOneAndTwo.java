package codeforces.contests1201_1300.problemset1277;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class AsSimpleAsOneAndTwo implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class Entry {
    private int idx;
    private char value;
    private boolean deleted;

    private Entry(int idx, char value) {
      this.idx = idx;
      this.value = value;
    }
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      char[] x = in.next().toCharArray();
      int n = x.length;
      List<Entry> list = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        list.add(new Entry(i, x[i]));
      }
      List<Integer> result = new ArrayList<>();
      for (int i = 2; i < list.size() - 2; i++) {
        if (list.get(i - 2).value == 't' && list.get(i - 1).value == 'w' && list.get(i).value == 'o' && list.get(i + 1).value == 'n' && list.get(i + 2).value == 'e') {
          result.add(i);
          list.get(i).deleted = true;
        }
      }
      List<Entry> next = new ArrayList<>();
      for (Entry entry : list) {
        if (!entry.deleted) {
          next.add(entry);
        }
      }
      for (int i = 1; i < next.size() - 1; i++) {
        if (next.get(i - 1).value == 't' && next.get(i).value == 'w' && next.get(i + 1).value == 'o') {
          next.get(i).deleted = true;
          result.add(next.get(i).idx);
        }
      }
      for (int i = 1; i < next.size() - 1; i++) {
        if (next.get(i - 1).value == 'o' && next.get(i).value == 'n' && next.get(i + 1).value == 'e') {
          next.get(i).deleted = true;
          result.add(next.get(i).idx);
        }
      }
      out.println(result.size());
      for (Integer idx : result) {
        out.print(idx + 1);
        out.print(' ');
      }
      out.println();
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
    try (AsSimpleAsOneAndTwo instance = new AsSimpleAsOneAndTwo()) {
      instance.solve();
    }
  }
}
